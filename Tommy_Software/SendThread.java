// package sample;

// これは送るためだけのスレッド。Presentの方にも書いてあるけどこれは別々に作業をするためにスレッドにしたよ。
// currentThreadは消してもいいけど二つのスレッドが立ってるかの確認に使えるから置いといてみたら？
// まさあきにやってもらいたいのはここかな？

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
                String line = sc1.nextLine();//空白文字含めた文章の入力
                while(line.length()>50){
                    System.out.println("50文字以内で入力してください。現在入力数："+line.length());//文字数を規制
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
