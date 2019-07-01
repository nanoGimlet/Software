import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;;
import javafx.scene.Scene;

public class PaneScene{
    private Scene scene = null;
    private Parent root = null;

    public PaneScene(){
        try{
            root = FXMLLoader.load(getClass().getResource("Pane.fxml"));
            scene = new Scene(root);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Scene getScene(){
        return scene;
    }
}