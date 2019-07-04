import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.naming.ldap.Control;
import javax.naming.ldap.SortKey;

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
    @FXML
    private AnchorPane escapeButton;

    static String roomName;
    public Connect client = portController.con;


    @FXML
    void initialize() throws Exception {
        RoomnameSet();
    }

    @FXML
    void onAction(ActionEvent event) throws Exception {
        Button b = (Button) event.getSource();
        roomName = b.getText();
        // 部屋に移動するとroomNameは更新されてる
        if (checkname(roomName)) {
            showChatButtonAction();
            Scene scene = ((Node) event.getSource()).getScene();
            Window window = scene.getWindow();
            window.hide();
        } else {
            System.err.println("not exists");
            System.err.println("Here shows:" + portController.chatname2.toString());
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
            e.printStackTrace();
        }
    }

    public boolean checkname(String chat) {
        for (String name : portController.chatname2) {
            if (chat.equals(name)) return true;
        }
        return false;
    }

    @FXML
    void getThema(ActionEvent event) {
        RoomnameSet();
    }

    @FXML
    void escape(ActionEvent event) throws Exception {
        Scene scene = ((Node) event.getSource()).getScene();
        Window window = scene.getWindow();
        window.hide();
        try {
            portController.commonSocket.close();
        } catch (Exception e) {
            System.out.println("escape error");
        }
    }

    public void RoomnameSet() {
        for (int i = 0; i < client.chatname.size(); i++) {
            switch (i) {
                case 0:
                    chatButton1.setText(client.chatname.get(0));
                    break;
                case 1:
                    chatButton2.setText(client.chatname.get(1));
                    break;
                case 2:
                    chatButton3.setText(client.chatname.get(2));
                    break;
                case 3:
                    chatButton4.setText(client.chatname.get(3));
                    break;
                case 4:
                    chatButton5.setText(client.chatname.get(4));
                    break;
                case 5:
                    chatButton6.setText(client.chatname.get(5));
                    break;
                case 6:
                    chatButton7.setText(client.chatname.get(6));
                    break;
                case 7:
                    chatButton8.setText(client.chatname.get(7));
                    break;
                case 8:
                    chatButton9.setText(client.chatname.get(8));
                    break;
                case 9:
                    chatButton10.setText(client.chatname.get(9));
                    break;
            }
        }
    }
}
