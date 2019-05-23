import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer{
    public static int PORT;    //  ポート番号を設定する
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        PORT = sc.nextInt();
        ServerSocket s = new ServerSocket(PORT);    //  ソケットを作成する
        System.out.println("Started: " + s);

        // ここでマルチスレッドを生成。今は３個だけ作れるようになってる
        
        try{
            for(int i = 0; i < 3; i++){
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