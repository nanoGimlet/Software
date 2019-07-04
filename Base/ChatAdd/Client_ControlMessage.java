import java.io.*;
import java.net.*;

import javax.swing.text.AttributeSet.CharacterAttribute;

public class Client_ControlMessage extends Thread {
    Socket socket;

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
                // System.out.println(Printon);
                // System.out.println(Connect.mychatroom);
                // System.out.println(ReadMessages);
                if (ReadMessages.charAt(0) == '[') {
                    show_log(ReadMessages);
                } else {
                    PrintSplit ps = new PrintSplit(ReadMessages);
                    if (ps.PrintRoom.equals(Connect.mychatroom)) {
                        System.out.println(ps.Printcontent);
                        System.out.println(ps.Printnewday);
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
        for (String mess : showmess)
            System.out.println(mess);
    }
}