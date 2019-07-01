import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainPortScene{
    private Scene scene = null;
    private Parent root = null;

    public MainPortScene(){
        try{
            root = FXMLLoader.load(getClass().getResource("MainPort.fxml"));
            scene = new Scene(root);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Scene getScene(){
        return scene;
    }
}