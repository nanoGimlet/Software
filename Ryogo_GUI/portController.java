import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class portController{

    static int portnumber;
    @FXML
    private TextArea portTextArea;

    @FXML
    private Label portLabel1;

    @FXML
    private Button portButton;

    @FXML

    void sendPort(ActionEvent event){
        String string_portnumber=portTextArea.getText();
        portTextArea.setText("");
        portnumber=Integer.parseInt(string_portnumber);

        try{
            showRoomButtonAction();
        } catch (Exception ex) {

        }
    }

    public static int getPort(){
        return portnumber;
    }

    void showRoomButtonAction() {
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("app2.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

        }
    }

}
