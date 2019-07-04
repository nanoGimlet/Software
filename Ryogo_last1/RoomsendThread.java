import java.net.Socket;

public class RoomsendThread extends Thread{
    private ReaderWriter RWsr;
    Socket socket;
    Connect client;
    public String mychtroom;

    public RoomsendThread (ReaderWriter RW, Connect client) {
        RWsr = RW;
        this.client = client;
        this.start();
    }

    @Override
    public void run() {
        mychtroom = FirstWindowController.mychatroom;
        RWsr.out.println(mychtroom + " ");
        RWsr.out.flush();
    }
}
