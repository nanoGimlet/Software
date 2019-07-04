import java.io.*;
import java.net.*;
import java.util.*;

public class MultiClient{
    public static void main(String[] args) throws IOException{
        InetAddress addr =     // ""�ł������String�^�ŔF�������̂ŏ�肭�����Ȃ�
         InetAddress.getByName("localhost");      //  IP�A�h���X�ւ̕ϊ�
         System.out.println("addr = " + addr);
         Scanner sc = new Scanner(System.in);
         JabberServer.PORT = sc.nextInt();
        Socket socket = new Socket("localhost", JabberServer.PORT);    //  �\�P�b�g�̐���
        try{
            System.out.println("socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));     //  �f�[�^��M�p�o�b�t�@�̐ݒ�
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);  //  ���M�o�b�t�@�ݒ�
            for(int i = 0; i < 10; i++){
                Scanner sc1 = new Scanner(System.in);
                String str = sc1.next();
                out.println(str);  //  �f�[�^���M�@������out���Ă������L�X�y�[�X��str�̓��e��u�����Ƃő�����
                // Client�ł�out��Server�ł�in�ɂȂ�BServer�ł͋t��
            }
            out.println("END");
        } finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}