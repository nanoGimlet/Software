import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class FirstWindowController {

    @FXML
    private Button chatButton2;

    @FXML
    private Button chatButton3;

    @FXML
    private Button chatButton1;

    @FXML
    void onAction(ActionEvent event) {
        try {
            showChatButtonAction();
        } catch (Exception ex) {
            System.out.println("error");
        }
    }

    void showChatButtonAction() {
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("app.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

        }
    }
}
