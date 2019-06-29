import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class portController {

    static int portnumber;
    public static Socket commonSocket;
    public static List<String> chatname2 = new ArrayList<String>();

    @FXML
    private TextArea portTextArea;
    @FXML
    private Label portLabel1;
    @FXML
    private Button portButton;

    @FXML
    void sendPort(ActionEvent event){
        String string_portnumber = portTextArea.getText();
        portTextArea.setText("");
        portnumber = Integer.parseInt(string_portnumber);
        try {
            showRoomButtonAction();
            chatClient(portnumber);
        } catch (Exception ex) {}
    }

    void chatClient(int PORT) throws IOException {
        String server = InetAddress.getLocalHost().getHostAddress();
        System.out.println("PORT:" + PORT);
        Socket socket = null;
        try {
            InetAddress addr = InetAddress.getByName(server);
            socket = new Socket(addr, PORT);
            commonSocket=socket;
            Connect con = new Connect(); //
            con.connect(socket); //
            chatname2=con.chatname;
        } catch (IOException e) {}
    }

    void showRoomButtonAction(){
        if (portnumber == ChatServer.PORT) {
            portLabel1.setText("                                   　　　　　　           ポート番号を入力してください");
            portLabel1.setTextFill(Color.BLACK);
            try {
                AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("app2.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println("error");
            }
        }
        else{
            portLabel1.setText("                                              ポート番号が正しくありません。もう一度入力してください。");
            portLabel1.setTextFill(Color.RED);
        }
    }

}

