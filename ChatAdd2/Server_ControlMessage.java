import java.io.*;
import java.net.Socket;
import java.util.*;

class Server_ControlMessage extends Thread {
    public static final int PORT = 19190;
    static List<Server_ControlMessage> threads;
    Socket socket;
    String chatroom_name;
    

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
            System.err.println(currentThread());
            System.err.println("*** Connected ***");
            while (true) {
                try {
                    ReaderWriter RWserver = new ReaderWriter(socket);
                    String mess = RWserver.in.readLine();
                    Scanner sc = new Scanner(mess);
                    chatroom_name = sc.next();
                    if(sc.hasNext()){
                        mess = sc.next();
                    }else{
                        show_list(socket, chatroom_name);
                        continue;
                    }
                    Date now = new Date();
                    String mestime = mess + "$!+" + now;
                    //if (ChatServer.list.get(chatroom_name).messlist.size() >= 500) {// 51個目がきたらポップして最新版にする
                    //}
                    System.out.println("mess : " + mestime);
                    if (mess == null) {
                        socket.close();
                        threads.remove(this);
                        return;
                    }
                    mestime =  chatroom_name + "&#^" + mestime;
                    ChatServer.list.get(chatroom_name).messlist.add(mestime);// キューにmessの保存
                    System.out.println(mestime);
                    talk(mestime);
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

    // これが新規ユーザーが来た時の履歴の出力
    public static void show_list(Socket socket,String chatroom_name) {
        try {
            ReaderWriter out_message = new ReaderWriter(socket);
            out_message.out.println(ChatServer.list.get(chatroom_name).messlist.toString());
        } catch (Exception e) {

        }
    }

    public void talk(String str) {
        for (int i = 0; i < threads.size(); i++) {
            Server_ControlMessage st = threads.get(i);
            if (st.isAlive()) {
                System.out.println("送信 : " + chatroom_name);
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
