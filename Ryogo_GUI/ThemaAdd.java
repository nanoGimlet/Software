import java.io.IOException;
import java.net.Socket;

public class ThemaAdd extends Thread {
    Socket socket;

    public ThemaAdd(Socket socket) {
        this.socket = socket;
        this.start();
    }

    @Override
    public void run() {
        System.err.println(currentThread());
        System.out.println("テーマ追加されましたよ:");
        String namelist = ChatServer.chatroom_name.get(ChatServer.chatroom_name.size() - 1);
        namelist = ")R&" + namelist;
        System.out.println(namelist);
        themaadd(namelist);
    }


    public void themaadd(String str) {
        for (int i = 0; i < Server_ControlMessage.threads.size(); i++) {
            Server_ControlMessage st2 = Server_ControlMessage.threads.get(i);
            if (st2.isAlive()) {
                st2.show(str);
            }
        }
    }
}
