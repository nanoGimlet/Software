import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    public static final int PORT = 19190;
    public static final int start_roomsize = 1;
    public static HashMap<String, Room> list = new HashMap<String, Room>();
    public static List<String> chatroom_name = new ArrayList<String>();

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.err.println("Started : " + PORT);
            System.err.println("部屋名を入力してください。部屋の上限数:" + start_roomsize);
            // データの入力とHashMapの初期化
            for(int i = 0; i < start_roomsize; i++) {
                Scanner sc1 = new Scanner(System.in);
                String name = sc1.next();
                chatroom_name.add(name);
                list.put(chatroom_name.get(i), new Room(chatroom_name.get(i)));
            }
            System.out.println(chatroom_name.toString());
            // ソケットを開いてるイメージ
            while (true) {
                try {
                    Socket socket = server.accept();
                    ThemaCreate tc = new ThemaCreate(socket);
                    Server_ControlMessage st = new Server_ControlMessage(socket);
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