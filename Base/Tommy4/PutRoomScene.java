import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class PutRoomScene{
    private Scene scene = null;
    private Parent root = null;

    public PutRoomScene(){
        try{
            root = FXMLLoader.load(getClass().getResource("PutRoomScene.fxml"));
            scene = new Scene(root);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Scene getScene(){
        return scene;
    }
}