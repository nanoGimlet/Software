import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.text.AttributeSet.CharacterAttribute;

public class Client_ControlMessage extends Thread {
    Socket socket;
    Connect client;// 自分を持っているクライアント

    public Client_ControlMessage(Socket socket, Connect client) {
        this.socket = socket;
        this.client = client;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                ReaderWriter reader = new ReaderWriter(socket);
                String ReadMessages = reader.in.readLine();
                // System.out.println(ReadMessages);
                if (ReadMessages.charAt(0) == '[') {// 履歴表示のため
                    show_log(ReadMessages);
                } else {// メッセージ表示
                    Scanner sc = new Scanner(ReadMessages);
                    String name = sc.next();// 送られてきたところの部屋名
                    String m = sc.next();// メッセージ本体
                    if (name.equals(client.mychatroom)) {// 自分と同じ部屋名なら処理する
                        if (m.charAt(0) == 'e') {// 投稿数があふれた時
                            String delete = m.substring(3);// errの文字削除
                            System.out.println(delete);// 文字表示
                            System.out.println("新しい部屋に移動して下さい。");

                            System.exit(1);// 強制終了（強制退出）
                        } else
                            System.out.println(ReadMessages);// 通常のメッセージ表示
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("closing...");
            try {
                socket.close();
            } catch (Exception a) {

            }
        }
    }

    // 履歴表示
    public void show_log(String text) {
        String tmp = text.substring(1, text.length() - 1);
        String showmess[] = tmp.split(", ");
        for (String mess : showmess)
            System.out.println(mess);
    }
}