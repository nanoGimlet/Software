import java.io.*;
import java.net.*;
import java.util.*;

public class Connect {
    public Socket soc = null;
   // private static final int PORT = 19190;
    public SendThread send;
    public Client_ControlMessage controlMessage;
    public String mychatroom;
    public void connect(Socket sct) {
        try {
            soc = sct;
            ReaderWriter RWclient = new ReaderWriter(soc);
            RWclient.out.flush();
            System.err.println("*** Connection Success ***");
            Scanner sc = new Scanner(System.in);
            System.out.println("以下のいずれかの部屋名を入力してください");
            System.out.println(ChatServer.chatroom_name.toString());
            mychatroom = sc.next();
            while (!checkname(mychatroom)) {
                    System.out.println("部屋名が違います。以下の部屋から選択してください。");
                    System.out.println(ChatServer.chatroom_name.toString()); 
                    mychatroom = sc.next();
            }
            send = new SendThread(new ReaderWriter(soc), this);
            send.start();
            controlMessage = new Client_ControlMessage(soc);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public boolean checkname(String chat){
        for(String name : ChatServer.chatroom_name){
            if(chat.equals(name)) return true;
        }
        return false;
    }
}
