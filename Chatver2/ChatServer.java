import java.io.IOException;
import java.net.*;

public class ChatServer {
    public static final int PORT = 19190;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.err.println("Started : " + PORT);
            System.err.println(InetAddress.getLocalHost().getHostAddress());
            while (true) {
                try {
                    Socket socket = server.accept();
                    ServerThread st = new ServerThread(socket);
                    st.start();
                } catch (IOException e) {
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
