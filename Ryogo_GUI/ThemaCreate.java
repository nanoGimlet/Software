import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ThemaCreate extends Thread {
    static int PORT = 19190;
    static ArrayList roomthreads;
    Socket socket;

    public ThemaCreate(Socket sct) {
        socket = sct;
        this.start();
    }

    @Override
    public void run() {
        System.err.println(currentThread());
        ReaderWriter RWSthema = null;
        try {
            RWSthema = new ReaderWriter(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RWSthema.out.println(ChatServer.chatroom_name.toString());
        RWSthema.out.flush();
    }
}