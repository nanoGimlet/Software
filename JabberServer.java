import java.io.*;
import java.net.*;
import java.util.*;

public class JabberServer{
    public static int PORT;    //  ポート番号を設定する
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        PORT = sc.nextInt();
        ServerSocket s = new ServerSocket(PORT);    //  ソケットを作成する
        System.out.println("Started: " + s);
        try{
            ServerThread[3] array = new ServerThread();
            for(int i = 0; i < 3; i++){
                Socket socket = s.accept();
                array[i] = new ServerThread(socket);
                array[i].start();
            }
        } catch(IOException e){
            System.out.println("IOException!");
            e.printStackTrace();
        } finally {
            s.close();
        }
    }
}