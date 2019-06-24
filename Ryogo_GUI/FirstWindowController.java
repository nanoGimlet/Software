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

    static String roomName; //
    static String mychatroom;
    //int once=0;

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
        } catch (Exception e) {
        }
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
            System.out.println("not exists");
            System.out.println("Here shows:"+chatname2.toString());
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

    //
    public Socket soc = null;
    public SendThread send;
    public Client_ControlMessage controlMessage;
    public static List<String> chatname2 = new ArrayList<String>();
    int once=0; //

    public void connect(Socket sct) {
        try {
            if(once==0) {
                soc = sct;
                ReaderWriter RWclient = new ReaderWriter(soc);
                RWclient.out.flush();
                System.err.println("*** Connection Success ***");
                ThemaAccept ta = new ThemaAccept(soc);
                ta.join();
                once=1;
            }
            /*System.out.println("以下のいずれかの部屋名を入力してください");
            System.out.println(chatname.toString());
            while (!checkname(roomName)) {
                System.out.println("部屋名が違います。以下の部屋から選択してください。");
                System.out.println(chatname.toString());
                mychatroom = FirstWindowController.roomName;
            }
            System.out.println(roomName);
            //send = new SendThread(new ReaderWriter(soc), this);
            send.start();
            controlMessage = new Client_ControlMessage(soc);
            */
        } catch (IOException e) {
            System.err.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkname(String chat) {
        for (String name : chatname2) {
            if (chat.equals(name)) return true;
        }
        return false;
    }//
}
