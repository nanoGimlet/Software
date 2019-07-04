import java.io.*;
import java.net.*;
import java.util.*;

public class MultiServer{
    public static int PORT;    //  �|�[�g�ԍ���ݒ肷��
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        PORT = sc.nextInt();
        ServerSocket s = new ServerSocket(PORT);    //  �\�P�b�g���쐬����
        System.out.println("Started: " + s);

        // �����Ń}���`�X���b�h�𐶐��B���͂R��������悤�ɂȂ��Ă�
        
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