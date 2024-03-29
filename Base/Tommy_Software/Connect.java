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
            ReaderWriter RWc = new ReaderWriter(soc);
            RWc.out.flush();
            System.err.println("*** Connection Success ***");
            SendThread r = new SendThread(new ReaderWriter (soc));
            r.start();
            ChatClient2 ch2 = new ChatClient2(soc);
            // while (soc != null && soc.isConnected()) {
            //     String line = RWc.in.readLine();
            //     System.out.println(line);
            // }
        } /*catch (UnknownHostException e) {
            System.err.println(e);
        }*/ catch (IOException e) {
            System.err.println(e);
        }
    }
}
