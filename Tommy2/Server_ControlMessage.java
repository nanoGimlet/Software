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
                    String chatroom_name = sc.next();
                    if(sc.hasNext()){
                        mess = sc.next();
                    }else{
                        show_queue(socket, chatroom_name);
                        continue;
                    }
                    Date now = new Date();
                    String mestime = mess + " " + now;
                    if (ChatServer.list.get(chatroom_name).queue.size() >= 50) {// 51個目がきたらポップして最新版にする
                        ChatServer.list.get(chatroom_name).queue.poll();
                    }
                    ChatServer.list.get(chatroom_name).queue.offer(mestime);// キューにmessの保存
                    System.out.println("mess : " + mestime);
                    if (mess == null) {
                        socket.close();
                        threads.remove(this);
                        return;
                    }
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

    public static void show_queue(Socket socket,String chatroom_name) {
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
