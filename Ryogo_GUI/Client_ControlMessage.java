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
    static int no = 0;
    static String day;
    static String content;
    Connect client;
    static String log;
    static int flag = 0;

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
                System.out.println(ReadMessages);
                if (ReadMessages.charAt(0) == '[') {
                    show_log(ReadMessages);
                } else if (ReadMessages.charAt(0) != '[' && ReadMessages.charAt(1) != ']') {
                    if(no == 0) {
                        no = Controller.number2;
                    }
                    PrintSplit ps = new PrintSplit(ReadMessages);
                    if (ps.PrintRoom.equals(FirstWindowController.roomName)) {
                        if (ps.Printcontent.charAt(0) == 'e') {// 投稿数があふれた時
                            String delete = ps.Printcontent.substring(3);// errの文字削除
                            System.out.println(delete);// 文字表示
                            System.out.println("新しい部屋に移動して下さい。");
                            // System.exit(1);//強制退出
                        } else {
                            System.out.print(no + " ");
                            System.out.println(ps.Printcontent);
                            System.out.println(ps.Printnewday);
                            no++;
                            day = ps.Printnewday;
                            content = ps.Printcontent;
                            Controller.talkPane = FXMLLoader.load(getClass().getResource("talkPane.fxml"));
                            Controller.ObservableList1.add(Controller.talkPane);
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
        log = text;
    }
}