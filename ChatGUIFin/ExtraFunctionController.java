import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Window;

public class ExtraFunctionController {

    @FXML
    private Button Button1;

    @FXML
    void onClose2Action(ActionEvent event){
        Scene scene=((Node)event.getSource()).getScene();
        Window window=scene.getWindow();
        window.hide();
    }
}


