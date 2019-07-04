import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PutRoomScene {
    private Scene scene = null;
    private Parent root = null;
    public static PutRoomNameController putroom;

    public PutRoomScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PutRoomName.fxml"));
            root = (Parent) fxmlLoader.load();
            putroom = (PutRoomNameController) fxmlLoader.getController();
            scene = new Scene(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }
}