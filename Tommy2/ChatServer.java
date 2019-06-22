import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    public static final int PORT = 19190;
    public static Map<String ,Room> list = new HashMap<String,Room>();
    public static List<String> chatroom_name=new ArrayList<String>(){{
        add("aaa");
        add("bbb");
        add("ccc");
        add("ddd");
        add("eee");
        add("fff");
        add("ggg");
        add("hhh");
        add("iii");
        add("jjj");
    }};
    public static void main(String[] args) {
        for(int i = 0; i<chatroom_name.size();i++){
            list.put(chatroom_name.get(i),new Room(chatroom_name.get(i)));
        }
        System.out.println(chatroom_name.toString());
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.err.println("Started : " + PORT);
            while (true) {
                try {
                    Socket socket = server.accept();
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
