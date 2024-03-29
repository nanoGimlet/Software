import java.io.*;
import java.net.Socket;
import java.util.*;


class ServerThread extends Thread {
    public static final int PORT = 19190;
    static List<ServerThread> threads;
    Socket socket;

    public ServerThread(Socket sct) {
        super();
        socket = sct;
        if (threads == null) {
            threads = new ArrayList<ServerThread>();
        }
        threads.add(this);
    }

    @Override
    public void run() {
        try {
            System.err.println("*** Connected ***");
            ReaderWriter RWs = new ReaderWriter(socket);

            while (true) {
                try {
                    String mess = RWs.in.readLine();
                    System.out.println("mess"+mess);
                    if (mess == null) {
                        socket.close();
                        threads.remove(this);
                        return;
                    }
                    talk(mess);
                } catch (IOException e) {
                    System.err.println("*** Connection closed ***");
                    socket.close();
                    threads.remove(this);
                    return;
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void talk(String str) {
        for(int i = 0; i < threads.size(); i++) {
            ServerThread st = threads.get(i);
            if (st.isAlive()) {
                st.talkone(str);
            }
        }
       // System.err.println(str);
    }

    public void talkone(String str) {
        try {
            ReaderWriter RWs = new ReaderWriter(socket);
            RWs.out.println(str);
            RWs.out.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
