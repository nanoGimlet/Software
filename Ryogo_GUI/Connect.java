import org.w3c.dom.Text;

import java.io.*;
import java.net.*;
import java.util.*;

public class Connect {
    public Socket soc = null;
    public static List<String> chatname = new ArrayList<String>();

    public void connect(Socket sct) {
        try {
            soc = sct;
            System.err.println("*** Connection Success ***");
            ThemaAccept ta = new ThemaAccept(soc);
            ta.join();
            System.out.println("以下のいずれかの部屋名を入力してください");
            System.out.println(chatname.toString());
            // ここの時点で部屋の名前を取得している
            //  ここまではCUIの挙動
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}