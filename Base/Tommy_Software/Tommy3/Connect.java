import java.io.*;
import java.net.*;
import java.util.*;

public class Connect {
    public Socket soc = null;
   // private static final int PORT = 19190;
    public SendThread send;//自分専用の書き込み専用のコントロールメッセージ
    public Client_ControlMessage controlMessage;//自分専用の読み込み用のコントロールメッセージ
    public String mychatroom;//自分自身の部屋名
    public static List<String> chatroom_name = new ArrayList<String>();//部屋の名前のリスト

    public void connect(Socket sct) {
        try {
            soc = sct;
            ReaderWriter RWclient = new ReaderWriter(soc);
            RWclient.out.flush();
            System.err.println("*** Connection Success ***");
            ThemaAccept ta = new ThemaAccept(soc);
            ta.join();
            Scanner sc = new Scanner(System.in);
            System.out.println("以下のいずれかの部屋名を入力してください");
            System.out.println(chatroom_name.toString());
            mychatroom = sc.next();
            while (!checkname(mychatroom)) {
                    System.out.println("部屋名が違います。以下の部屋から選択してください。");
                    System.out.println(ChatServer.chatroom_name.toString()); 
                    mychatroom = sc.next();
            }
            send = new SendThread(new ReaderWriter(soc), this);
            send.start();
            controlMessage = new Client_ControlMessage(soc, this);
        } catch (IOException e) {
            System.err.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //部屋名が存在するかどうか
    public boolean checkname(String chat){
        for(String name : chatroom_name){
            if(chat.equals(name)) return true;
        }
        return false;
    }
}
