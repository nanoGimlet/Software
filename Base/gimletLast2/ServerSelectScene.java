import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ServerSelectScene {
    private Scene scene = null;
    private Parent root = null;

    public static ServerSelectController serverselectcontroller;

    public ServerSelectScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ServerSelectRoom.fxml"));
            root = (Parent) fxmlLoader.load();
            serverselectcontroller = (ServerSelectController) fxmlLoader.getController();
            scene = new Scene(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }
}