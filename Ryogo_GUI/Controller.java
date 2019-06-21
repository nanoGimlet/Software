//コンパイル時、UTF-8でエンコード

import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Window;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;


public class Controller{
    @FXML
    private VBox VBox1;

    @FXML
    private HBox HBox1;

    @FXML
    private AnchorPane button1;

    @FXML
    private Button closeButton;

    @FXML
    private Button mentionButton;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private TextArea textArea;

    @FXML
    private ListView<String> ListView1;

    @FXML
    private ComboBox<String> mentionBox1;

    int i=1;

    @FXML
    void onButton1Action(ActionEvent event) {
        String str = textArea.getText();
        if (str.length() > 100){
            label1.setText("100文字以内で入力してください．(現在："+str.length()+"文字)");
            label1.setTextFill(Color.RED);
        }
        else {
            //the sending message event to server is needed. it will be come true with SendThread.
            label1.setText("文字入力してね");
            label1.setTextFill(Color.BLACK);
            ListView1.getItems().add(i+"："+str); //here is ServerThread
            textArea.setText("");
            mentionBox1.getItems().add(i+"");
            i++;
        }
    }

    @FXML
    void onMentionAction(ActionEvent event){
        String value=mentionBox1.getValue();
        textArea.setText(">>"+value+" ");
    }

    @FXML
    void extraFuncButtonAction(ActionEvent event){
        try {
            showExtraButtonAction();
        } catch (Exception ex) {
            System.out.println("error");
        }
    }

    void showExtraButtonAction() {
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("extraApp.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {

        }
    }

    @FXML
    void onCloseAction(ActionEvent event){
        Scene scene=((Node)event.getSource()).getScene();
        Window window=scene.getWindow();
        window.hide();
    }

}
