import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    public static final int PORT = 19190;
    public static final int start_roomsize = 1;
    public static Map<String, Room> list = new HashMap<String, Room>();
    public static List<String> chatroom_name = new ArrayList<String>();

    //サーバー側の部屋の追加（投稿数が上限に達してあふれた時の新部屋）
    public static void addmap(String name, String mess) {
        System.out.println("部屋追加されました");
        if (!chatroom_name.contains(name)) {
            Connect.chatroom_name.add(name);//クライアント側の部屋の追加（名前だけ）
            chatroom_name.add(name);
            Room room = new Room(name);
            list.put(name, room);
            room.queue.offer(mess);
        }
        System.out.println(chatroom_name.toString());

    }

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.err.println("Started : " + PORT);
            System.out.println("部屋名を入力してください。部屋の上限数：" + start_roomsize);
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < start_roomsize; i++) {
                String tmp = sc.next();
                chatroom_name.add(tmp);
                list.put(tmp, new Room(tmp));
            }
            sc.close();
            System.out.println(chatroom_name.toString());
            while (true) {
                try {
                    Socket socket = server.accept();
                    ThemaCreate tc = new ThemaCreate(socket);
                    Server_ControlMessage st = new Server_ControlMessage(socket);

                    st.start();
                } catch (IOException e) {
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
