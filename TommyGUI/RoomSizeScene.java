import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;;
import javafx.scene.Scene;

public class RoomSizeScene{
    private Scene scene = null;
    private Parent root = null;

    public RoomSizeScene(){
        try{
            root = FXMLLoader.load(getClass().getResource("RoomSizeOver.fxml"));
            scene = new Scene(root);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Scene getScene(){
        return scene;
    }
}