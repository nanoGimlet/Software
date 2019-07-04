import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PutRoomNameController {

    private boolean roomfirst = true;
    public static int roomsize = 1;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    public TextField roomname;

    @FXML
    public Button roomnamebutton;

    public static int count = 1;

    @FXML
    void initialize() {

    }

    @FXML
    void pushbutton() {
        try {
            switch (count) {
            case 1:
                ServerSelectScene.serverselectcontroller.rooom1.setVisible(true);
                ServerSelectScene.serverselectcontroller.rooom1.setText(roomname.getText());
                count++;
                break;
            case 2:
                ServerSelectScene.serverselectcontroller.rooom2.setVisible(true);
                ServerSelectScene.serverselectcontroller.rooom2.setText(roomname.getText());
                count++;
                break;
            case 3:
                ServerSelectScene.serverselectcontroller.rooom3.setVisible(true);
                ServerSelectScene.serverselectcontroller.rooom3.setText(roomname.getText());
                count++;
                break;
            case 4:
                ServerSelectScene.serverselectcontroller.rooom4.setVisible(true);
                ServerSelectScene.serverselectcontroller.rooom4.setText(roomname.getText());
                count++;
                break;
            case 5:
                ServerSelectScene.serverselectcontroller.rooom5.setVisible(true);
                ServerSelectScene.serverselectcontroller.rooom5.setText(roomname.getText());
                count++;
                break;
            case 6:
                ServerSelectScene.serverselectcontroller.rooom6.setVisible(true);
                ServerSelectScene.serverselectcontroller.rooom6.setText(roomname.getText());
                count++;
                break;
            case 7:
                ServerSelectScene.serverselectcontroller.rooom7.setVisible(true);
                ServerSelectScene.serverselectcontroller.rooom7.setText(roomname.getText());
                count++;
                break;
            case 8:
                ServerSelectScene.serverselectcontroller.rooom8.setVisible(true);
                ServerSelectScene.serverselectcontroller.rooom8.setText(roomname.getText());
                count++;
                break;
            case 9:
                ServerSelectScene.serverselectcontroller.rooom9.setVisible(true);
                ServerSelectScene.serverselectcontroller.rooom9.setText(roomname.getText());
                count++;
                break;
            case 10:
                ServerSelectScene.serverselectcontroller.rooom10.setVisible(true);
                ServerSelectScene.serverselectcontroller.rooom10.setText(roomname.getText());
                count++;
                break;
            }
            ChatServer.chatroom_name.add(roomname.getText());
            ChatServer.list.put(roomname.getText(), new Room(roomname.getText()));
            ThemaAdd themaAdd = new ThemaAdd(ChatServer.socket);
            System.out.println(ChatServer.chatroom_name.toString());
        } catch (Exception e) {
            System.out.println("これはおかしい");
        }
        roomname.setText("");
        if (roomfirst) {
            ChatServer th = new ChatServer();
            th.start();
            roomfirst = false;
        }
        roomsize++;
        MainServer.changeScene(MainServer.sceneType.RoomSelect);
    }
}
