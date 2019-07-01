import java.io.*;
import java.net.*;

public class Client_ControlMessage extends Thread {
    Socket socket;
    int no = 1;
    Connect client;

    public Client_ControlMessage(Socket socket, Connect client) {
        this.client = client;
        this.socket = socket;
        this.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                ReaderWriter reader = new ReaderWriter(socket);
                String ReadMessages = reader.in.readLine();
                if (ReadMessages.charAt(0) == '[' && ReadMessages.charAt(1) != ']') {
                    show_log(ReadMessages);
                } else if(ReadMessages.charAt(0) != '[' && ReadMessages.charAt(1) != ']') {
                    PrintSplit ps = new PrintSplit(ReadMessages);
                    if (ps.PrintRoom.equals(client.mychatroom)) {
                        if (ps.Printcontent.charAt(0) == 'e') {// 投稿数があふれた時
                            String delete = ps.Printcontent.substring(3);// errの文字削除
                            System.out.println(delete);// 文字表示
                            System.out.println("新しい部屋に移動して下さい。");
                            // System.exit(1);//強制退出
                        } else{
                        System.out.print(no + " ");
                        System.out.println(ps.Printcontent);
                        System.out.println(ps.Printnewday);
                        no++;
                        }
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

    // ReadMessageに来たのが履歴だった時の特別な対応
    public void show_log(String text) {
        String tmp = text.substring(1, text.length() - 1);
        String showmess[] = tmp.split(", ");
        for (String mess : showmess) {
            PrintSplit pslog = new PrintSplit(mess);
            System.out.print(no + " ");
            System.out.println(pslog.Printcontent);
            System.out.println(pslog.Printnewday);
            no++;
        }

    }
}