import org.w3c.dom.Text;

import java.io.*;
import java.net.*;
import java.util.*;

public class Connect {
    public Socket soc = null;
   // private static final int PORT = 19190;
    public SendThread send;
    public Client_ControlMessage controlMessage;
    public static List<String> chatname = new ArrayList<String>();
    public static String mychatroom;
    public static int no;
    public static String date;
    public static String text;

    public void connect(Socket sct) {
        try {
            soc = sct;
            ReaderWriter RWclient = new ReaderWriter(soc);
            RWclient.out.flush();
            System.err.println("*** Connection Success ***");
            ThemaAccept ta = new ThemaAccept(soc);
            ta.join();
            System.out.println("以下のいずれかの部屋名を入力してください");
            System.out.println(chatname.toString());
            /*
            mychatroom = FirstWindowController.roomName;
            while (!checkname(mychatroom)) {
                System.out.println("部屋名が違います。以下の部屋から選択してください。");
                System.out.println(chatname.toString());
                mychatroom = FirstWindowController.roomName;
            }
            System.out.println(mychatroom);

            send = new SendThread(new ReaderWriter(soc), this);

            send.start();
            controlMessage = new Client_ControlMessage(soc);
            no=controlMessage.getNo();
            date=controlMessage.getDay();
            text=controlMessage.getContent();
            */
        } catch (IOException e) {
            System.err.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkname(String chat){
        for(String name : chatname){
            if(chat.equals(name)) return true;
        }
        return false;
    }
/*
    public static int getNo2(){
        return no;
    }
    public static String getDate2(){
        return date;
    }
    public static String getText2(){
        return text;
    }*/
}