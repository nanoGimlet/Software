// package sample;

// これがメインのサーバーだよ。
// こいつ自体はもう書くことないかも…あとはスレッドを強化するだけだ！

import java.io.*;
import java.net.*;

public class ChannelServer {
    public static final int PORT = 19190;
    public static void main(String[] args) throws IOException{
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Started: " + s);
        try{
            while(true){
                Socket socket = s.accept();
                new ServerThread(socket).start();
            }
        } catch(IOException e){
            System.out.println("IOException!");
            e.printStackTrace();
        } finally {
            s.close();
        }
    }
}