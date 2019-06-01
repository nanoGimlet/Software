// package sample;

// これは複数のクライアントを相手にするために作ったスレッドだよ。これがないと1対複数ができない！
// ここにクライアントに送る用意ができてるから、ここを改良するのが僕の仕事。

import java.net.*;
import java.io.*;

class ServerThread extends Thread{
    private Socket soc;

    public ServerThread(Socket sct){
        soc = sct;
    }

    @Override
    public void run(){
        try {
            ReadWrite RWserver = new ReadWrite(soc);
            while(true){
                String line = RWserver.in.readLine();
                if(line.equals("END")) break;
                System.out.println(line);
                RWserver.out.println(line);
            }
        } catch(IOException ioex) {
            ioex.printStackTrace();
        } finally {
            try{
                soc.close();
            } catch (IOException ie){
                ie.printStackTrace();
            }
        }
    }
}