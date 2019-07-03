//元SendThread

import java.util.*;

class Client_SendThread extends Thread {
    private ReaderWriter RWcl;
    public Connect client;

    public Client_SendThread(ReaderWriter RW, Connect client) {
        RWcl = RW;
        this.client = client;
    }

    @Override
    public void run() {
        RWcl.out.println(client.mychatroom + " ");
        try {
            System.out.println(currentThread());
            while (true) {
                Scanner sc1 = new Scanner(System.in);
                String mess = sc1.nextLine();
                while (mess.length() > 50) {
                    System.out.println("50文字以内で入力してください。入力数：" + (mess.length()));
                    mess = sc1.nextLine();
                }
                if (mess == "END") {
                    break;
                } else {
                    Date date = new Date();
                    String date2 = date.toString();
                    PrintSplit sendmessage = new PrintSplit(client.mychatroom, mess, date2);
                    String send = sendmessage.Sendform();
                    RWcl.out.println(send);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}