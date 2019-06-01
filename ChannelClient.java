// package sample;

// これがメインのクライアントだよ。
// ここにクラスを追加していこう。
// りょうごはGUIにするときもしかしたらこいつ自体もスレッドにしないといけないかもしれないからそれは頑張ってくれ。

import java.io.*;
import java.net.*;

public class ChannelClient {
    public static void main(String[] args) throws IOException{
        InetAddress addr = InetAddress.getByName("localhost");
        System.out.println("addr = " + addr);
        Socket socket = new Socket("localhost", ChannelServer.PORT);
        try{
            System.out.println("socket = " + socket);
            ReadWrite RWclient = new ReadWrite(socket);
            SendThread st1 = new SendThread(RWclient);
            PresentThread pt1 = new PresentThread(RWclient);
            st1.start();
            pt1.start();
            st1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}