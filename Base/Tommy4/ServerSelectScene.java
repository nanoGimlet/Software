import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ServerSelectScene{
    private Scene scene = null;
    private Parent root = null;

    public ServerSelectScene(){
        try{
            root = FXMLLoader.load(getClass().getResource("ServerSelectRoom.fxml"));
            scene = new Scene(root);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public Scene getScene(){
        return scene;
    }
}