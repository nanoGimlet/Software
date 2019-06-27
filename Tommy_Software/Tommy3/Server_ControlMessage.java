import java.io.*;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.*;

class Server_ControlMessage extends Thread {
    public static final int PORT = 19190;
    static List<Server_ControlMessage> threads;
    Socket socket;

    public Server_ControlMessage(Socket sct) {
        super();
        socket = sct;
        if (threads == null) {
            threads = new ArrayList<Server_ControlMessage>();
        }
        threads.add(this);
    }

    @Override
    public void run() {
        try {
            System.err.println("*** Connected ***");
            while (true) {
                try {
                    ReaderWriter RWserver = new ReaderWriter(socket);
                    String mess = RWserver.in.readLine();

                    Scanner sc = new Scanner(mess);
                    String chatroom_name = sc.next();//部屋名

                    if (sc.hasNext()) {//メッセージがある時
                        mess = sc.next();//メッセージ本体
                    } else {//初めてその部屋にはいった＝メッセージがない
                        show_queue(socket, chatroom_name);//履歴を送る
                        continue;
                    }
                    Date now = new Date();
                    String mestime = mess + " " + now;
                    if (ChatServer.list.get(chatroom_name).queue.remainingCapacity() <= 0) {// 容量が０になったら新しい部屋を作る
                        String scan = chatroom_name.substring(chatroom_name.length() - 1);//添え字取得
                        String newchatroom = chatroom_name;//新しい部屋名のための変数
                        int num = 1;//添え字更新のため
                        try {//scanが数字なら数字の変換
                            num = Integer.parseInt(scan);
                            System.out.println(num);
                            newchatroom = chatroom_name.substring(0,chatroom_name.length()-1);//添え字なしで新しい部屋名の作成
                        } catch (NumberFormatException e) {
                            //ないなら何もしない
                            System.out.println("エラー" + num);

                        }
                        String number = String.valueOf(num + 1);//添え字の更新
                        ChatServer.addmap(newchatroom + number, mestime);//添え字をつけた新しい部屋名を用いて、新しい部屋を追加
                        //あふれたことを伝えるメッセージを送信（便宜的に全員に送信）
                        //頭の文字（=chatroom_name）は部屋名を識別するために元の部屋名をつける
                        talk(chatroom_name + " err投稿数が５００件を超えました。");

                    } else {
                        ChatServer.list.get(chatroom_name).queue.offer(mestime);// キューにmessの保存
                    }
                    System.out.println("mess : " + mestime);
                    if (mess == null) {
                        socket.close();
                        threads.remove(this);
                        return;
                    }
                    talk(chatroom_name + " " + mestime);//識別するために部屋名（＝chatroom_name）を頭につける
                } catch (IOException e) {
                    System.err.println("*** Connection closed ***");
                    socket.close();
                    threads.remove(this);
                    return;
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void show_queue(Socket socket, String chatroom_name) {

        try {
            ReaderWriter out_message = new ReaderWriter(socket);
            out_message.out.println(ChatServer.list.get(chatroom_name).queue.toString());
        } catch (Exception e) {

        }
    }

    public void talk(String str) {
        for (int i = 0; i < threads.size(); i++) {
            Server_ControlMessage st = threads.get(i);
            if (st.isAlive()) {
                st.show(str);
            }
        }
    }

    public void show(String str) {
        try {
            ReaderWriter RWs = new ReaderWriter(socket);
            RWs.out.println(str);
            RWs.out.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
