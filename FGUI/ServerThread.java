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
            while (true) {
                try {
                    ReaderWriter RWserver = new ReaderWriter(socket);
                    String mess = RWserver.in.readLine();
                    Date now = new Date();
                    String mestime = mess + ' ' + now;
                    System.out.println("mess : " + mestime);
                    if (mess == null) {
                        socket.close();
                        threads.remove(this);
                        return;
                    }
                    talk(mestime);
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
        for (int i = 0; i < threads.size(); i++) {
            ServerThread st = threads.get(i);
            if (st.isAlive()) {
                st.show(str);
            }
        }
    }

    public void show(String str) {
        try {
            ReaderWriter RWs = new ReaderWriter(socket);
            RWs.out.println(str);
            RWs.out.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }


}