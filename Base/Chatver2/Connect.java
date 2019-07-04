import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connect {
    public Socket soc = null;
    private static final int PORT = 19190;

    public void connect(Socket sct) {
        try {
            soc = sct;
            ReaderWriter RWclient = new ReaderWriter(soc);
            RWclient.out.flush();
            System.err.println("*** Connection Success ***");
            SendThread send = new SendThread(new ReaderWriter(soc));
            send.start();
            ChatClient2 ch2 = new ChatClient2(soc);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
