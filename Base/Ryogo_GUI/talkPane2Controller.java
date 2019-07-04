import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class talkPane2Controller {
    @FXML
    private Label dateLabel2;
    @FXML
    private Label talkLabel2;

    @FXML
    void initialize(){
        dateLabel2.setText(Controller.getNumber2()-1+". "+Controller.getData2());
        talkLabel2.setText(Controller.getStrText2()); //getText
    }
}

