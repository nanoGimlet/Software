import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    public static final int PORT = 19190;
    public static final int start_roomsize = 1;
    public static HashMap<String, Room> list = new HashMap<String, Room>();
    public static List<String> chatroom_name = new ArrayList<String>();

    public static void addmap(String name) {
        System.out.println("部屋が追加されました");
        if (!chatroom_name.contains(name)) {
            Connect.chatname.add(name);//クライアント側の部屋の追加（名前だけ）
            chatroom_name.add(name);
            Room room = new Room(name);
            list.put(name, room);
        }
        System.out.println(chatroom_name.toString());
    }

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.err.println("Started : " + PORT);
            System.err.println("部屋名を入力してください。部屋の上限数:" + start_roomsize);
            for (int i = 0; i < start_roomsize; i++) {
                Scanner sc1 = new Scanner(System.in);
                String name = sc1.next();
                chatroom_name.add(name);
                list.put(name, new Room(name));
            }
            Server_SendThread chatname = new Server_SendThread();
            System.out.println(chatroom_name.toString());
            // ソケットを開いてるイメージ
            while (true) {
                try {
                    Socket socket = server.accept();
                    ThemaCreate tc = new ThemaCreate(socket);
                    Server_ControlMessage st = new Server_ControlMessage(socket, chatname);
                    st.start();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
