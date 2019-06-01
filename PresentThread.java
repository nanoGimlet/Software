// package sample;

// これはクライアントで送られてきたやつを表示するスレッド。
// スレッドにした理由はGUIで作るとき送信する間にサーバーからデータが送られてくるかもしれないから別々に作業をするため。
// System.outにすると標準出力でout.printlnとかにするとout領域に文字列が格納されるよ。


import java.net.*;
import java.io.*;

class PresentThread extends Thread {
    private ReadWrite RWcl;

    public PresentThread (ReadWrite RW) {
        RW = RWcl;
    }

    @Override
    public void run() {
        try {
            System.out.println(currentThread());
            while (true) {
                String str = RWcl.in.readLine();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
