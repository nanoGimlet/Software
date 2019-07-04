import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;

public class ChatClient {
    public static int PORT;
    public static void main(String[] args) throws IOException {
        String server = InetAddress.getLocalHost().getHostAddress();
        System.out.print("PORT : ");
        Scanner scp = new Scanner(System.in);
        PORT = scp.nextInt();
        Socket socket = null;
        try {
            InetAddress addr = InetAddress.getByName(server);
            socket = new Socket(addr, PORT);
            Connect con = new Connect();
            con.connect(socket);
        }catch (IOException e) {
        }
    }
}
