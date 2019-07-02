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

import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    @FXML
    private VBox VBox1;
    @FXML
    private HBox HBox1;
    @FXML
    private AnchorPane button1;
    @FXML
    private Button closeButton;
    @FXML
    private Button mentionButton;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private TextArea textArea;
    @FXML
    private ListView<AnchorPane> ListView1;
    @FXML
    public static ObservableList<AnchorPane> ObservableList1;
    @FXML
    private ComboBox<String> mentionBox1;
    @FXML
    public static AnchorPane talkPane;
    @FXML
    private AnchorPane talkPane2;
    @FXML
    private Label dateLabel;
    @FXML
    private Label talkLabel;


    public static String data, data2;
    public static String str;
    public static String strText, strText2;
    public static String mess;
    public Client_SendThread send;
    public Client_ControlMessage controlMessage;
    Connect client = portController.con;
    Socket socket = portController.commonSocket;
    static int number, number2;
    public static String mychatroom = FirstWindowController.roomName;
    public String tmp;

    @FXML
    void initialize() throws Exception {
        ObservableList1 = FXCollections.observableArrayList();
        ListView1.setItems(ObservableList1);
        label2.setText("                      " + FirstWindowController.mychatroom);
    }

    @FXML
    void startAction(ActionEvent event) throws Exception {
        startThread();
    }

    @FXML
    void onButton1Action(ActionEvent event) throws Exception {
        mess = null;
        str = null;
        str = textArea.getText();
        if (str.length() > 100) {
            label1.setText("100文字以内で入力してください．(現在：" + str.length() + "文字)");
            label1.setTextFill(Color.RED);
        } else {
            if (str != null) {
                mess = str;
                new Client_SendThread(new ReaderWriter(socket), client).start();
            }
            number = controlMessage.getNo();
            strText = controlMessage.getContent();
            data = controlMessage.getDay();
            System.out.println("おれ動いてないよね");
            System.out.println(number);
            System.out.println(strText);
            System.out.println(data);
            talkPane = FXMLLoader.load(getClass().getResource("talkPane.fxml"));
            ObservableList1.add(talkPane);
            label1.setText("文字入力してね");
            label1.setTextFill(Color.BLACK);
            textArea.setText("");
        }
    }

    //
    void startThread() throws Exception {
        ReaderWriter RWroom = new ReaderWriter(socket);
        RWroom.out.println(mychatroom + " ");
        RWroom.out.flush();
        controlMessage = new Client_ControlMessage(socket, client);    // クライアントの文字列の受け取り体制ができる
        System.out.println("走らせますよエンテイさん");
        while (true) {
            System.out.println(controlMessage.getLog());
            if (controlMessage.getLog() != null) {
                int count = 1;
                String len = controlMessage.getLog();
                if (len.charAt(0) == '[' && len.charAt(1) == ']') {
                    break;
                } else {
                    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    tmp = len.substring(1, len.length() - 1);
                    String showmess[] = tmp.split(", ");
                    for (String mess : showmess) {
                        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                        PrintSplit pslog = new PrintSplit(mess);
                        System.out.print(count + " ");
                        System.out.println(pslog.Printcontent);
                        System.out.println(pslog.Printnewday);
                        count++;
                        number = count;
                        strText = pslog.Printcontent;
                        data = pslog.Printnewday;
                        talkPane = FXMLLoader.load(getClass().getResource("talkPane.fxml"));
                        ObservableList1.add(talkPane);

                    }
                    break;
                }
            }
        }
        // 部屋の名前をまず送る
        /*System.out.println(mychatroom);
        ReaderWriter RSroom = new ReaderWriter(socket);
        RSroom.out.println(mychatroom + " ");
        RSroom.out.flush();
         */
    }

    //
    @FXML
    void onCloseAction(ActionEvent event) {
        Scene scene = ((Node) event.getSource()).getScene();
        Window window = scene.getWindow();
        window.hide();
    }

    static String getData() {
        return data;
    }

    public static String getStrText() {
        return strText;
    }

    public static String getStr() {
        return str;
    }

    public static int getNumber() {
        return number;
    }

    static String getData2() {
        return data2;
    }

    public static String getStrText2() {
        return strText2;
    }

    public static int getNumber2() {
        return number2;
    }
}
