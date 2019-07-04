import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

// 1つのクライアントとの通信を行なうスレッド
class ChatServerThread extends Thread {
    static int port = 19190;
    static ArrayList threads; // 現在動作中のスレッドの集合
    Socket socket; // このクライアントに対応するソケット
    // String nickname=null; // このクライアントのニックネーム

    // コンストラクタ(使用するソケットを指定)
    public ChatServerThread(Socket sct) {
        super(); // Threadクラスのコンストラクタを呼ぶ
        socket = sct;
        if (threads == null) {
            threads = new ArrayList(); // スレッドの集合の初期化
        }
        threads.add(this); // スレッドの集合に自分を追加
    }

    /*public String getNickname() { // 自分のニックネームを返す
        return nickname;
    }*/

    public void run() { // スレッドで実行される内容
        try {
            System.err.println("*** Connected ***");
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while(true) {
                try {
                    String str = in.readLine(); // クライアントから一行入力
                    if (str == null) { // 接続が切れていたら
                        socket.close(); // ソケット切断
                        threads.remove(this); // スレッドの集合から自分を削除
                        return; // スレッド消滅
                    }
                    /*if (s.startsWith("NICK:")) { // NICK:コマンドなら
                        StringTokenizer st = new StringTokenizer(s, ":");
                        st.nextToken();
                        // NICK:の後のトークンをニックネームとする
                        nickname = st.nextToken();
                        out.print("Hello " + nickname + "! You entered.\r\n");
                        out.flush();
                    } else {
                        // ニックネームが登録されていたら
                        if (nickname != null) {
                            talk(s); // メッセージ送信
                        } else {
                            out.print("Error! You must specify your nickname.\r\n");
                            out.flush();
                        }
                    }*/
                    talk(str);
                } catch (IOException e) { // 突然接続が切れた場合
                    System.err.println("*** Connection closed ***");
                    socket.close();
                    threads.remove(this); // スレッドの集合から自分を削除
                    return; // スレッド消滅
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void talk(String message) {
        // スレッドの集合のそれぞれについて…
        for (int i = 0; i < threads.size(); i++) {
            ChatServerThread t = (ChatServerThread)threads.get(i);
            if (t.isAlive()) { // そのスレッドが動作していたら
                t.talkone(this, message); // そのスレッドにメッセージを送信
            }
        }
        System.err.println(message);
    }

    // そのスレッドにメッセージを送信
    public void talkone(ChatServerThread talker, String message){
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            // String nick = talker.getNickname();
            if (talker == this) { // 自分からのメッセージ
                out.print(message + "\r\n");
            } else { // 他人からのメッセージ
                out.print(message + "\r\n");
            }
            out.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
