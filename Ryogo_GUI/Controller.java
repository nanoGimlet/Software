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

public class Controller{
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
    private ObservableList<AnchorPane> ObservableList1;
    @FXML
    private ComboBox<String> mentionBox1;
    @FXML
    private AnchorPane talkPane,talkPane2;
    @FXML
    private Label dateLabel;
    @FXML
    private Label talkLabel;


    public static String data,data2;
    public static String str;
    public  static String strText,strText2;
    int once=0;
    public SendThread send;
    public Client_ControlMessage controlMessage;
    Connect client;
    Socket socket;
    static int number,number2;

    @FXML
    void initialize() throws Exception {
        ObservableList1 = FXCollections.observableArrayList();
        ListView1.setItems(ObservableList1);
        label2.setText("                      "+FirstWindowController.mychatroom);
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                runLine();
            }
        };

        Timer timer=new Timer();
        timer.scheduleAtFixedRate(task,10000,10000);
    }

    void runLine() {
        try {
            number2 = controlMessage.getNo();
            strText2 = controlMessage.getContent();
            data2 = controlMessage.getDay();
            talkPane2 = FXMLLoader.load(getClass().getResource("talkPane2.fxml"));
            ObservableList1.add(talkPane2);
        }catch(Exception e){}
    }

    @FXML
    void onButton1Action(ActionEvent event)throws Exception {
        str = textArea.getText();
        if (str.length() > 100){
            label1.setText("100文字以内で入力してください．(現在："+str.length()+"文字)");
            label1.setTextFill(Color.RED);
        }
        else {
            label1.setText("文字入力してね");
            label1.setTextFill(Color.BLACK);
            //startThread();
            send = new SendThread(new ReaderWriter(portController.commonSocket), client);
            send.start();
            send.sleep(100);
            controlMessage = new Client_ControlMessage(portController.commonSocket);
            //send.start();
            send.sleep(200);
            number=controlMessage.getNo();
            strText=controlMessage.getContent();
            data=controlMessage.getDay();
            System.out.println("@Controller now:"+strText);
            talkPane = FXMLLoader.load(getClass().getResource("talkPane.fxml"));
            ObservableList1.add(talkPane);
            //startThread();
            textArea.setText("");
        }
    }
    //
    void startThread() throws Exception {
        send = new SendThread(new ReaderWriter(portController.commonSocket), client);
        send.start();
        controlMessage = new Client_ControlMessage(portController.commonSocket);
        //send.start();
        send.sleep(1000);
    }
    //
    @FXML
    void onCloseAction(ActionEvent event){
        Scene scene=((Node)event.getSource()).getScene();
        Window window=scene.getWindow();
        window.hide();
    }

    static String getData(){
        return data;
    }

    public static String getStrText(){
        return strText;
    }

    public static String getStr(){
        return str;
    }

    public static int getNumber(){
        return number;
    }

    static String getData2(){
        return data2;
    }

    public static String getStrText2(){
        return strText2;
    }

    public static int getNumber2(){
        return number2;
    }
}
