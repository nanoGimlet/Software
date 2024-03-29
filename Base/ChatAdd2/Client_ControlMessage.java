import java.io.*;
import java.net.*;

import javax.swing.text.AttributeSet.CharacterAttribute;

public class Client_ControlMessage extends Thread {
    Socket socket;
    int no = 1;

    public Client_ControlMessage(Socket socket) {
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
                    if (ps.PrintRoom.equals(Connect.mychatroom)) {
                        System.out.print(no + " ");
                        System.out.println(ps.Printcontent);
                        System.out.println(ps.Printnewday);
                        no++;
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