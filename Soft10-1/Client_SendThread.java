import java.util.*;

class Client_SendThread extends Thread {
    private ReaderWriter RWcl;
    public Connect client;
    public String mychatroom = Controller.mychatroom;
    String line = null;

    public Client_SendThread(ReaderWriter RW, Connect client) {
        RWcl = RW;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            System.out.println(currentThread());
            System.out.println("∞");
            line = Controller.mess;
            if(line == null) {
            }else {
                System.out.println(line);
                Date date = new Date();
                String date2 = date.toString();
                PrintSplit sendmessage = new PrintSplit(mychatroom, line, date2);
                String send = sendmessage.Sendform();
                RWcl.out.println(send);
                RWcl.out.flush();
            }
            //  }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}