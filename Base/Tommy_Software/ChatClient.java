import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {
    public static final int PORT = 19190;
    public static void main(String[] args) throws IOException {
        String server = "localhost";
        Socket socket = null;
        try {
            InetAddress addr = InetAddress.getByName(server);
            socket = new Socket(addr, PORT);
            Connect con= new Connect();
            con.connect(socket);
        }catch (IOException e) {
        }
    }
}
