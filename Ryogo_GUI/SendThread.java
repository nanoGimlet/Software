import java.net.*;
import java.io.*;
import java.util.*;

import javax.sound.sampled.Line;

class SendThread extends Thread {
    private ReaderWriter RWcl;
    public Connect client;

    public SendThread(ReaderWriter RW, Connect client) {
        RWcl = RW;
        //this.client = client;
    }

    @Override
    public void run() {
        RWcl.out.println(client.mychatroom+" ");
        try {
            System.out.println(currentThread());
                //Scanner sc1 = new Scanner(System.in);
                String line = /*connect*/FirstWindowController.mychatroom+" ";
                int length = line.length();
                /*line += sc1.nextLine();
                while (line.length() > 100+length) {
                    System.out.println("100文字以内で入力してください。入力数：" + (line.length()-length));
                    line = client.mychatroom+" "; 
                    line += sc1.nextLine();
                }
                */
                line+=Controller.getText();
                //System.out.println(line);
            System.out.println(line);
                RWcl.out.println(line);

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}