import java.io.*;
import java.net.*;
import java.util.*;

class ChatServer extends Thread {
    public static int PORT = 19190;
    public static Socket socket;
    public static final int start_roomsize = 1;
    public static HashMap<String, Room> list = new HashMap<String, Room>();
    public static List<String> chatroom_name = new ArrayList<String>();

    public static void addmap(String name) {
        System.out.println("部屋が追加されました");
        if (!chatroom_name.contains(name)) {
            Connect.chatname.add(name);// クライアント側の部屋の追加（名前だけ）
            chatroom_name.add(name);
            Room room = new Room(name);// リストの追加
            list.put(name, room);
        }
        System.out.println(chatroom_name.toString());

    }

    @Override
    public void run() {
        try{
        ServerSocket server = new ServerSocket(PORT);
        Server_SendThread chatname = new Server_SendThread();
        // ソケットを開いてるイメージ
        while (true) {
            try {
                socket = server.accept();// クライアントとつながる
                ThemaCreate tc = new ThemaCreate(socket);
                Server_ControlMessage st = new Server_ControlMessage(socket, chatname);
                // st.start();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
       }catch(IOException e){
        System.err.println(e);
    }
    }
}