import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// こいつは部屋分けの通信際できればいい
public class Chatroom extends Thread {
    static List<Chatroom> threads;
    public static int PORT;
    String Name;

    public Chatroom(String Roomname, int PortNo) {
        super();
        Name = Roomname;
        PORT = PortNo;
        if(threads == null) {
            threads = new ArrayList<Chatroom>();
        }
        threads.add(this);
        this.start();
    }

    @Override
    public void run() {
        try {
            System.err.println(currentThread());
            ServerSocket roomserver = new ServerSocket(PORT);
            System.err.println("Started : " + PORT + " : " + Name);
            Socket roomsocket = roomserver.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
