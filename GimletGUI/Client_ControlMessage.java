import javafx.fxml.FXMLLoader;

import java.io.*;
import java.net.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Window;
import javafx.scene.control.ComboBox;

public class Client_ControlMessage extends Thread {
    Socket socket;
    static int no = 1;
    static String day;
    static String content;
    Connect client;
    static String log;

    public Client_ControlMessage(Socket socket, Connect client) {
        this.socket = socket;
        this.client = client;
        this.start();
    }

    public int getNo() {
        return no;
    }

    public String getDay() {
        return day;
    }

    public String getContent() {
        return content;
    }

    public String getLog() {
        return log;
    }

    @Override
    public void run() {
        try {
            ReaderWriter reader = new ReaderWriter(socket);
            while (true) {
                String ReadMessages = reader.in.readLine();
                System.out.println("送られてきたよ");
                System.out.println(ReadMessages);
                if (ReadMessages.charAt(0) == '[') {
                    System.out.println("履歴だあ");
                    show_log(ReadMessages);
                } else if (ReadMessages.charAt(0) != '[' && ReadMessages.charAt(1) != ']') {
                    System.out.println("メッセージだあ");
                    PrintSplit ps = new PrintSplit(ReadMessages);
                    System.out.println("部屋の名前:" + ps.PrintRoom);
                    if (ps.PrintRoom.equals(FirstWindowController.mychatroom)) {
                        if (ps.Printcontent.charAt(0) == 'e') {// 投稿数があふれた時
                            String delete = ps.Printcontent.substring(3);// errの文字削除
                            System.out.println(delete);// 文字表示
                            System.out.println("新しい部屋に移動して下さい。");
                            // System.exit(1);//強制退出
                        } else {
                            System.out.println("ここはメッセージが送られてきたところ");
                            System.out.print(no + " ");
                            System.out.println(ps.Printcontent);
                            System.out.println(ps.Printnewday);
                            no++;
                            day = ps.Printnewday;
                            content = ps.Printcontent;
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
        /*String tmp = text.substring(1, text.length() - 1);
        String showmess[] = tmp.split(", ");
        for (String mess : showmess) {
            PrintSplit pslog = new PrintSplit(mess);
            System.out.print(no + " ");
            System.out.println(pslog.Printcontent);
            System.out.println(pslog.Printnewday);
            no++;
            content=pslog.Printcontent;
            day=pslog.Printnewday;*/
        log = text;
    }
}