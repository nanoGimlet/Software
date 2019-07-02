import java.io.*;
import java.net.Socket;
import java.util.*;

class Server_ControlMessage extends Thread {
        public static final int PORT = 19190;
        static List<Server_ControlMessage> threads;
        Socket socket;
        String chatroom_name;
        public Server_SendThread send;

        public static final int maxsize = 100;


    public Server_ControlMessage(Socket sct, Server_SendThread send) {
        super();
        // this.send = send;
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
                    // ここにすでに時間が持たされたものが飛んでくる
                    ReaderWriter RWserver = new ReaderWriter(socket);
                    String mess = RWserver.in.readLine();
                    Scanner sc = new Scanner(mess);
                    System.out.println(mess);
                    chatroom_name = sc.next();
                    if(sc.hasNext()){
                    }else{
                        show_list(socket, chatroom_name);
                        continue;
                    }

                    System.out.println("mess : " + mess);
                    if (mess == null) {
                        socket.close();
                        threads.remove(this);
                        return;
                    }

                    PrintSplit ps = new PrintSplit(mess);
                    chatroom_name = ps.PrintRoom;
                    if(ChatServer.list.get(chatroom_name).messlist.size() >= maxsize) {
                        System.out.println("容量の上限に達しました。");
                        send.PutName(chatroom_name);
                        String message = ")rr投稿数が" + maxsize + "件を超えました。";
                        PrintSplit ps2 = new PrintSplit(chatroom_name, message, ps.Printday);
                        talk(ps2.Sendform());
                    }else {
                        mess = mess + ")~|" + (ChatServer.list.get(chatroom_name).messlist.size()+1);
                        ChatServer.list.get(chatroom_name).messlist.add(mess);
                        talk(mess);
                    }
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
            out_message.out.flush();
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