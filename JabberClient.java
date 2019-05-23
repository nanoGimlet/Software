import java.io.*;
import java.net.*;
import java.util.*;

public class JabberClient{
    public static void main(String[] args) throws IOException{
        InetAddress addr =     // ""でくくるとString型で認識されるので上手くいかない
         InetAddress.getByName("localhost");      //  IPアドレスへの変換
         System.out.println("addr = " + addr);
         Scanner sc = new Scanner(System.in);
         JabberServer.PORT = sc.nextInt();
        Socket socket = new Socket("localhost", JabberServer.PORT);    //  ソケットの生成
        try{
            System.out.println("socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));     //  データ受信用バッファの設定
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);  //  送信バッファ設定
            for(int i = 0; i < 10; i++){
                Scanner sc1 = new Scanner(System.in);
                String str = sc1.next();
                out.println(str);  //  データ送信
            }
            out.println("END");
        } finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}