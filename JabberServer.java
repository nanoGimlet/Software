import java.io.*;
import java.net.*;
import java.util.*;

public class JabberServer{
    public static int PORT;    //  �|�[�g�ԍ���ݒ肷��
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        PORT = sc.nextInt();
        ServerSocket s = new ServerSocket(PORT);    //  �\�P�b�g���쐬����
        System.out.println("Started: " + s);
        try{
            Socket socket = s.accept();     //  �R�l�N�V�����ݒ�v����҂�
            try{
                System.out.println("Connection accepted: " + socket);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));     //  �f�[�^��M�p�o�b�t�@�̐ݒ�
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);  //  ���M�o�b�t�@�ݒ�
                while(true){
                    String str = in.readLine();     //  �f�[�^�̎�M
                    if(str.equals("END")) break;
                    System.out.println(str);
                }
            } finally {
                System.out.println("closing...");
                socket.close();
            }
        } finally {
            s.close();
        }
    }
}