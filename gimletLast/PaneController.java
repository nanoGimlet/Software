import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

public class PaneController {

    public static boolean firstcheck = false;
    public static String roomname;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public TextArea textarea;

    @FXML
    private Button backbutton;

    @FXML
    void initialize() {

    }

    @FXML
    private void backButton() {
        MainServer.changeScene(MainServer.sceneType.RoomSelect);
    }
}
