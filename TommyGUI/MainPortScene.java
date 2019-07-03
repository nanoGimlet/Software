import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainPortScene {
    private Scene scene = null;
    private Parent root = null;
    public static MainPortController portcontroller;

    public MainPortScene() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPort.fxml"));
            root = (Parent) fxmlLoader.load();
            portcontroller = (MainPortController) fxmlLoader.getController();
            scene = new Scene(root);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }
}