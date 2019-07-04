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
            addname(str);

        } catch (IOException e) {
            System.err.println(e);
        } finally {
        }
    }

    public static void  addname(String text){
        String tmp = text.substring(1, text.length()-1);
        String showmess[] = tmp.split(", ");
        for(String mess : showmess)
        Connect.chatroom_name.add(mess);
    }

}
