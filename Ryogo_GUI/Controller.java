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
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Window;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

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
    private ListView<String> ListView1;
    //@FXML
    //private ListView<AnchorPane> ListView2; //
    //@FXML
    //private ObservableList<AnchorPane> ObservableList1;
    @FXML
    private ComboBox<String> mentionBox1;

    static String str;
    int once=0;
    public SendThread send;
    public Client_ControlMessage controlMessage;
    Connect client;
    Socket socket;

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
            ListView1.getItems().add(str);
            //ObservableList1.setItem()
            startThread();
            textArea.setText("");
        }
    }

    void startThread() throws Exception {
        if (once == 0) {
            String server = InetAddress.getLocalHost().getHostAddress();
            InetAddress addr = InetAddress.getByName(server);
            socket = new Socket(addr, portController.portnumber);
            once = 1;

        }
        send = new SendThread(new ReaderWriter(socket), client);
        controlMessage = new Client_ControlMessage(socket);
        send.start();
    }

    @FXML
    void onCloseAction(ActionEvent event){
        Scene scene=((Node)event.getSource()).getScene();
        Window window=scene.getWindow();
        window.hide();
    }

    static String getText(){
        return str;
    }
}
