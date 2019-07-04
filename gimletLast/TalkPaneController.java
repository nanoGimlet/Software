import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TalkPaneController {

    @FXML
    private Label dateLabel;

    @FXML
    private Label talkLabel;

    @FXML
    private Label numLabel;

    @FXML
    void initialize(){
        if(Client_ControlMessage.flag == 0) {
            dateLabel.setText(Controller.getData());
            numLabel.setText(Integer.toString(Controller.getNumber()-1)+". ");
            talkLabel.setText(Controller.getStrText()); //getText
        }else {
            dateLabel.setText(Client_ControlMessage.day);
            numLabel.setText(Integer.toString(Client_ControlMessage.no - 1)+". ");
            talkLabel.setText(Client_ControlMessage.content); //getText
        }
    }
}
