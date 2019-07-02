import javax.naming.ldap.SortKey;
import java.io.*;
import java.net.*;

public class ChatClient2 extends Thread {
    Socket socket;

    public ChatClient2(Socket socket) {
        this.socket = socket;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                ReaderWriter reader = new ReaderWriter(socket);
                String ReadMessages = reader.in.readLine();
                System.out.println(ReadMessages);
            }
        } catch (IOException e) {
            System.out.println("closing...");
            try {
                socket.close();
            } catch (Exception a) {

            }
        }
    }
}