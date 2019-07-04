import java.io.IOException;
import java.net.Socket;

public class ThemaAccept extends Thread{
    static int PORT = 19190;
    Socket socket;
    public  ThemaAccept(Socket sct) {
        socket = sct;
        this.start();
    }

    @Override
    public  void run() {
        try {
            System.err.println(currentThread());
            ReaderWriter RWCthema = new ReaderWriter(socket);
            String str = RWCthema.in.readLine();
            int begin = 1;
            for(int i = 1; i < str.length(); i++) {
                if((str.charAt(i) == ',' && str.charAt(i+1) == ' ')){
                    Connect.chatname.add(str.substring(begin, i));
                    begin = i+2;
                }else if(str.charAt(i) == ']') {
                    Connect.chatname.add(str.substring(begin, i));
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
        }
    }
}