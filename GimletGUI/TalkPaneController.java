import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TalkPaneController {

    @FXML
    private Label dateLabel;

    @FXML
    private Label talkLabel;

    @FXML
    void initialize(){
        if(Client_ControlMessage.flag == 0) {
            dateLabel.setText(Controller.getData());
            talkLabel.setText(Controller.getNumber() - 1 + ". " + Controller.getStrText()); //getText
        }else {
            dateLabel.setText(Client_ControlMessage.day);
            talkLabel.setText(Client_ControlMessage.no - 1 + ". " + Client_ControlMessage.content); //getText
        }
    }
}
