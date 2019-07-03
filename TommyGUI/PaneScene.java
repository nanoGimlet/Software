import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PaneScene {
    private Scene scene = null;
    private Parent root = null;
    public static PaneController paneroom;

    public PaneScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Pane.fxml"));
            root = (Parent) fxmlLoader.load();
            paneroom = (PaneController) fxmlLoader.getController();
            scene = new Scene(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }
}