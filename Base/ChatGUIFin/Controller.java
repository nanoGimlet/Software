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

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

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
    @FXML
    private  TextArea mentionArea;


    public static String data;
    public static String str;
    public static String strText;
    public static String mess;
    public static Client_ControlMessage controlMessage;
    Connect client = portController.con;
    Socket socket = portController.commonSocket;
    public static int number, number2;
    public static String mychatroom = FirstWindowController.roomName;
    public String tmp;
    public static String mention;

    @FXML
    void initialize() throws Exception {
        ObservableList1 = FXCollections.observableArrayList();
        ListView1.setItems(ObservableList1);
        label2.setText(FirstWindowController.roomName);
    }

    @FXML
    void startAction(ActionEvent event) throws Exception {
        startThread();
        label1.setText("文字入力してね");
        label1.setTextFill(Color.BLACK);
    }

    @FXML
    void mentionAction(ActionEvent event){
        mention=mentionArea.getText();
        textArea.setText(">>"+mention+"　");
        mentionArea.setText("");
    }

    @FXML
    void onButton1Action(ActionEvent event) throws Exception {
        mess = null;
        str = null;
        str = textArea.getText();
        if (str.length() > 100) {
            label1.setText("100文字以内で入力してください．(現在：" + str.length() + "文字)");
            label1.setTextFill(Color.RED);
        } else if(str.length() == 0) {
            label1.setText("入力がありません");
            label1.setTextFill(Color.RED);
        }else {
            if (str != null) {
                mess = str;
                new Client_SendThread(new ReaderWriter(socket), client).start();
            }
            label1.setText("文字入力してね");
            label1.setTextFill(Color.BLACK);
            textArea.setText("");
        }
    }

    //
    void startThread() throws Exception {
        mychatroom = FirstWindowController.roomName;
        ReaderWriter RWroom = new ReaderWriter(socket);
        RWroom.out.println(mychatroom + " ");
        RWroom.out.flush();
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("走らせますよエンテイさん");
        controlMessage = new Client_ControlMessage(socket, client);    // クライアントの文字列の受け取り体制ができる
        while (true) {
            System.out.println(controlMessage.getLog());
            if (controlMessage.getLog() != null) {
                String len = controlMessage.getLog();
                if (len.charAt(0) == '[' && len.charAt(1) == ']') {
                    number2 = 1;
                    Client_ControlMessage.flag = 1;
                    break;
                } else {
                    // ここでコントローラ迫真の処理
                    tmp = len.substring(1, len.length() - 1);
                    String showmess[] = tmp.split(", ");
                    for (String mess : showmess) {
                        PrintSplit pslog = new PrintSplit(mess);
                        number = pslog.PrintNo;
                        strText = pslog.Printcontent;
                        data = pslog.Printnewday;
                        talkPane = FXMLLoader.load(getClass().getResource("talkPane.fxml"));
                        ObservableList1.add(talkPane);
                        TimeUnit.MILLISECONDS.sleep(100);   // これは必要なsleep
                    }
                    number2 = number;
                    System.out.println(number2);
                    Client_ControlMessage.flag = 1;
                    break;
                }
            }
        }
        System.out.println(number2);
    }

    //
    @FXML
    void onCloseAction(ActionEvent event) {
        controlMessage.flag = 0;
        // controlMessage.stopRunning();
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

    public static int getNumber() {
        return number;
    }

}
