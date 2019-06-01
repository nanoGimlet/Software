// package sample;

// これは送るためだけのスレッド。Presentの方にも書いてあるけどこれは別々に作業をするためにスレッドにしたよ。
// currentThreadは消してもいいけど二つのスレッドが立ってるかの確認に使えるから置いといてみたら？
// まさあきにやってもらいたいのはここかな？

import java.net.*;
import java.io.*;
import java.util.*;

class SendThread extends Thread {
    private ReadWrite RWcl;

    public  SendThread (ReadWrite RW) {
        RWcl = RW;
    }

    @Override
    public void run() {
        try {
            System.out.println(currentThread());
            while (true) {
                Scanner sc1 = new Scanner(System.in);
                String line = sc1.next();
                if (line == "END") {
                    break;
                } else {
                    RWcl.out.println(line);
                }
                System.out.println(RWcl.in.readLine());
            }
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }
    }
}
