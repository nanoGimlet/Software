import java.net.*;
import java.io.*;
import java.util.*;

import javax.sound.sampled.Line;

class SendThread extends Thread {
    private ReaderWriter RWcl;

    public  SendThread (ReaderWriter RW) {
        RWcl = RW;
    }

    @Override
    public void run() {
        try {
            System.out.println(currentThread());
            while (true) {
                Scanner sc1 = new Scanner(System.in);
                String line = sc1.nextLine();
                while(line.length()>50){
                    System.out.println("50•¶ŽšˆÈ“à‚Å“ü—Í‚µ‚Ä‚­‚¾‚³‚¢"+line.length());
                    line = sc1.nextLine();
                }             
                if (line == "END") {
                    break;
                } else {
                    RWcl.out.println(line);
                }
                // System.out.println(RWcl.in.readLine());
             }              
        }catch(Exception e) {
                System.out.println("IOException");
                e.printStackTrace();
           }
        }
    }
