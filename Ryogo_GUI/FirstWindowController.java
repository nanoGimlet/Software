import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class FirstWindowController {

    @FXML
    private Button chatButton1;
    @FXML
    private Button chatButton2;
    @FXML
    private Button chatButton3;
    @FXML
    private Button chatButton4;
    @FXML
    private Button chatButton5;
    @FXML
    private Button chatButton6;
    @FXML
    private Button chatButton7;
    @FXML
    private Button chatButton8;
    @FXML
    private Button chatButton9;
    @FXML
    private Button chatButton10;
    @FXML
    private Button updateButton;

    static String roomName;
    static String mychatroom;
    public Socket soc = null;
    public SendThread send;
    public Client_ControlMessage controlMessage;
    public static List<String> chatname2 = new ArrayList<String>();
    int once=0;

    void chooseChat() throws Exception {
        String server = InetAddress.getLocalHost().getHostAddress();
        InetAddress addr = InetAddress.getByName(server);
        Socket socket = new Socket(addr, portController.portnumber);
        try {
            if(once==0) {
                Connect con2 = new Connect();
                con2.connect(socket);
                chatname2=con2.chatname;
                once=1;
            }
        } catch (Exception e) {}
    }

    @FXML
    void onAction(ActionEvent event) throws Exception {
        chooseChat();
        Button b = (Button) event.getSource();
        roomName = b.getText();
        System.out.println(roomName);
        if(checkname(roomName)) {
            System.out.println("OK.");
            mychatroom=roomName;
            showChatButtonAction();
        }else {
            System.err.println("not exists");
            System.err.println("Here shows:"+chatname2.toString());
        }
    }

    void showChatButtonAction() {
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("app.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

        }
    }

    public boolean checkname(String chat) {
        for (String name : chatname2) {
            if (chat.equals(name)) return true;
        }
        return false;
    }

    int i=4;

    @FXML
    void getThema(ActionEvent event){
        String new_thema= "テーマ"; //
        switch(i){
            case 4:
                chatButton4.setText(new_thema);
                break;

            case 5:
                chatButton5.setText(new_thema);
                break;

            case 6:
                chatButton6.setText(new_thema);
                break;

            case 7:
                chatButton7.setText(new_thema);
                break;

            case 8:
                chatButton8.setText(new_thema);
                break;

            case 9:
                chatButton9.setText(new_thema);
                break;

            case 10:
                chatButton10.setText(new_thema);
                break;
        }
        i++;
    }
}
