import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TalkPaneController {

    @FXML
    private Label dateLabel;

    @FXML
    private Label talkLabel;

    @FXML
    void initialize(){
        dateLabel.setText(Controller.getData());
        talkLabel.setText(Controller.getNumber() - 1 + ". " + Controller.getStrText()); //getText
    }
}
