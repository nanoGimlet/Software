import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Translate;

public class MainServer extends Application {

    enum sceneType {
        Port, RoomSelect,Scene1,Scene2,Scene3,Scene4,Scene5,Scene6,Scene7,Scene8,Scene9,Scene10,addthema,upgradethema;
    }

    private static MainPortScene portscene = null;
    private static ServerSelectScene selectroomscene = null;
    private static PaneScene pane = null;
    public static Stage stage = null;
    


    @Override
    public void start(Stage primaryStage) {
        try {
            portscene = new MainPortScene();
            selectroomscene = new ServerSelectScene();
            pane = new PaneScene();
            stage = primaryStage;
            stage.setScene(portscene.getScene());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeScene(sceneType scene){
        switch(scene){
            case Port:
            stage.setScene(portscene.getScene());
            break;
            case RoomSelect:
            stage.setScene(selectroomscene.getScene());
            break;
            case Scene1:
            stage.setScene(pane.getScene());
            break;
            case Scene2:
            stage.setScene(pane.getScene());
            break;
            case Scene3:
            stage.setScene(pane.getScene());
            break;
            case Scene4:
            stage.setScene(pane.getScene());
            break;
            case Scene5:
            stage.setScene(pane.getScene());
            break;
            case Scene6:
            stage.setScene(pane.getScene());
            break;
            case Scene7:
            stage.setScene(pane.getScene());
            break;
            case Scene8:
            stage.setScene(pane.getScene());
            break;
            case Scene9:
            stage.setScene(pane.getScene());
            break;
            case Scene10:
            stage.setScene(pane.getScene());
            break;
            case addthema:
            stage.setScene(pane.getScene());
            break;
            case upgradethema:
            stage.setScene(pane.getScene());
            break;
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}
