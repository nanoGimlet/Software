import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class Controller{
    @FXML
    private VBox VBox1;

    @FXML
    private HBox HBox1;

    @FXML
    private AnchorPane button1;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private TextArea textArea;

    @FXML
    void onButton1Action(ActionEvent event) {
        String str = textArea.getText();
        Label label3 = new Label();
        label3.setText(str);
        HBox1.setHgrow(label3,Priority.ALWAYS);
        textArea.setText("");
    }

}
