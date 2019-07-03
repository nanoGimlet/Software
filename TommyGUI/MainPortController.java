import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class MainPortController {

    @FXML
    private ResourceBundle resources;

    @FXML
    public TextField porttextfield;

    @FXML
    private Button portbutton;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    }

    @FXML
    private void pushbutton() {
        try {
            String s = porttextfield.getText();
            ChatServer.PORT = Integer.parseInt(s);
            System.out.println(ChatServer.PORT);
        } catch (Exception e) {
        }
        MainServer.changeScene(MainServer.sceneType.RoomSelect);
    }
}
