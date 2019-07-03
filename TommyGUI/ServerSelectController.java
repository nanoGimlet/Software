import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ServerSelectController {
    

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    public Button rooom1;
    @FXML
    public Button rooom2;
    @FXML
    public Button rooom3;
    @FXML
    public Button rooom4;
    @FXML
    public Button rooom5;
    @FXML
    public Button rooom6;
    @FXML
    public Button rooom7;
    @FXML
    public Button rooom8;
    @FXML
    public Button rooom9;
    @FXML
    public Button rooom10;

    @FXML
    private Button addThema;
    @FXML
    private Button updateThema;

    @FXML
    void initialize() {
        rooom1.setVisible(false);
        rooom2.setVisible(false);
        rooom3.setVisible(false);
        rooom4.setVisible(false);
        rooom5.setVisible(false);
        rooom6.setVisible(false);
        rooom7.setVisible(false);
        rooom8.setVisible(false);
        rooom9.setVisible(false);
        rooom10.setVisible(false);

    }

    @FXML
    private void room1() {
        MainServer.changeScene(MainServer.sceneType.Scene1);
    }

    @FXML
    private void room2() {
        MainServer.changeScene(MainServer.sceneType.Scene2);
    }

    @FXML
    private void room3() {
        MainServer.changeScene(MainServer.sceneType.Scene3);
    }

    @FXML
    private void room4() {
        MainServer.changeScene(MainServer.sceneType.Scene4);
    }

    @FXML
    private void room5() {
        MainServer.changeScene(MainServer.sceneType.Scene5);
    }

    @FXML
    private void room6() {
        MainServer.changeScene(MainServer.sceneType.Scene6);
    }

    @FXML
    private void room7() {
        MainServer.changeScene(MainServer.sceneType.Scene7);
    }

    @FXML
    private void room8() {
        MainServer.changeScene(MainServer.sceneType.Scene8);
    }

    @FXML
    private void room9() {
        MainServer.changeScene(MainServer.sceneType.Scene9);
    }

    @FXML
    private void room10() {
        MainServer.changeScene(MainServer.sceneType.Scene10);
    }

    @FXML
    private void addThema() {
        MainServer.changeScene(MainServer.sceneType.AddThema);
    }

    @FXML
    private void upgradeThema() {
        MainServer.changeScene(MainServer.sceneType.Scene1);
    }
}
