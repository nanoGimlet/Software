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
                String Printon = null;
                String Printcontent = null;
                for(int i = 0; i < ReadMessages.length(); i++) {
                    if(ReadMessages.charAt(i) == '^') {
                        Printon = ReadMessages.substring(0, i);
                        Printcontent = ReadMessages.substring(i+1, ReadMessages.length());
                        break;
                    }
                }
                // System.out.println(Printon);
                // System.out.println(Connect.mychatroom);
                // System.out.println(ReadMessages);
                if(ReadMessages.charAt(0)=='['){
                    show_log(ReadMessages);
                }else if(Printon.equals(Connect.mychatroom)) {
                    System.out.println(Printcontent);
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
    public void  show_log(String text){
        String tmp = text.substring(1, text.length()-1);
        String showmess[] = tmp.split(", ");
        for(String mess : showmess)
        System.out.println(mess);
    }
}