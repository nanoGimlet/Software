import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class MainPortController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField porttextfield;


    @FXML
    private Button portbutton;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    }
    @FXML
    private void pushbutton(){
        try{
           // ChatServer.PORT = Integer.parseInt(porttextfield.getText());
        }catch(Exception e){
        }
        MainServer.changeScene(MainServer.sceneType.RoomSelect);
        portbutton.setDisable(false);
    }
}
