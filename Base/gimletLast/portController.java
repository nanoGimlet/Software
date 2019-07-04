import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class portController {

    static int portnumber;
    public static Socket commonSocket;
    public static List<String> chatname2 = new ArrayList<String>();
    public static Connect con;

    @FXML
    private TextField portTextField;
    @FXML
    private Label portLabel1;
    @FXML
    private Button portButton;

    @FXML
    void sendPort(ActionEvent event){
        String string_portnumber = portTextField.getText();  // 19190の番号を取得
        portTextField.setText("");
        portnumber = Integer.parseInt(string_portnumber);   // 19190をint型に
        try {
            showRoomButtonAction(event);
            chatClient(portnumber);
        } catch (Exception ex) {}
    }

    void chatClient(int PORT) throws IOException {
        String server =InetAddress.getLocalHost().getHostAddress();
        System.out.println(server);
        System.out.println("PORT:" + PORT);
        Socket socket = null;
        // ここでサーバーとの通信が始まる
        try {
            InetAddress addr = InetAddress.getByName(server);
            System.out.println(addr);
            socket = new Socket(addr, PORT);
            commonSocket=socket;
            System.out.println(commonSocket.getInetAddress());
            con = new Connect(); //
            con.connect(socket); //
            chatname2 = con.chatname;
        } catch (IOException e) {System.out.println("not connected");}
    }

    void showRoomButtonAction(ActionEvent event){
        if (portnumber == ChatServer.PORT) {
            try {
                AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("app2.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                Scene thisScene = ((Node) event.getSource()).getScene();
                Window window = thisScene.getWindow();
                window.hide();

            } catch (Exception e) {
                System.out.println("error");
            }
        }
        else{
            portLabel1.setText("IDが正しくありません。もう一度入力してください。");
            portLabel1.setTextFill(Color.RED);
        }
    }

}

