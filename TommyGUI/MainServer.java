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
        Port, RoomSelect, Scene1, Scene2, Scene3, Scene4, Scene5, Scene6, Scene7, Scene8, Scene9, Scene10, AddThema;
    }

    private static MainPortScene portscene = null;
    private static ServerSelectScene selectroomscene = null;
    private static PutRoomScene putroomscene = null;
    private static PaneScene pane = null;
    public static Stage stage = null;

    @Override
    public void start(Stage primaryStage) {
        try {
            portscene = new MainPortScene();
            putroomscene = new PutRoomScene();
            selectroomscene = new ServerSelectScene();
            pane = new PaneScene();
            stage = primaryStage;
            stage.setScene(portscene.getScene());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeScene(sceneType scene) {
        switch (scene) {
        case Port:
            stage.setScene(portscene.getScene());
            break;
        case RoomSelect:
            stage.setScene(selectroomscene.getScene());
            break;
        case Scene1:
        PaneScene.paneroom.firstcheck = true;
        PaneScene.paneroom.roomname = ServerSelectScene.serverselectcontroller.rooom1.getText();
        PaneScene.paneroom.textarea.setText("");
        Server_ControlMessage.showmain();
            stage.setScene(pane.getScene());
            break;
        case Scene2:
        PaneScene.paneroom.firstcheck = true;
        PaneScene.paneroom.roomname = ServerSelectScene.serverselectcontroller.rooom2.getText();
        PaneScene.paneroom.textarea.setText("");
        Server_ControlMessage.showmain();
            stage.setScene(pane.getScene());
            break;
        case Scene3:
        PaneScene.paneroom.firstcheck = true;
        PaneScene.paneroom.roomname = ServerSelectScene.serverselectcontroller.rooom3.getText();
        PaneScene.paneroom.textarea.setText("");
        Server_ControlMessage.showmain();
            stage.setScene(pane.getScene());
            break;
        case Scene4:
        PaneScene.paneroom.firstcheck = true;
        PaneScene.paneroom.roomname = ServerSelectScene.serverselectcontroller.rooom4.getText();
        PaneScene.paneroom.textarea.setText("");
        Server_ControlMessage.showmain();
            stage.setScene(pane.getScene());
            break;
        case Scene5:
        PaneScene.paneroom.firstcheck = true;
        PaneScene.paneroom.roomname = ServerSelectScene.serverselectcontroller.rooom5.getText();
        PaneScene.paneroom.textarea.setText("");
        Server_ControlMessage.showmain();
            stage.setScene(pane.getScene());
            break;
        case Scene6:
        PaneScene.paneroom.firstcheck = true;
        PaneScene.paneroom.roomname = ServerSelectScene.serverselectcontroller.rooom6.getText();
        PaneScene.paneroom.textarea.setText("");
        Server_ControlMessage.showmain();
            stage.setScene(pane.getScene());
            break;
        case Scene7:
        PaneScene.paneroom.firstcheck = true;
        PaneScene.paneroom.roomname = ServerSelectScene.serverselectcontroller.rooom7.getText();
        PaneScene.paneroom.textarea.setText("");
        Server_ControlMessage.showmain();
            stage.setScene(pane.getScene());
            break;
        case Scene8:
        PaneScene.paneroom.firstcheck = true;
        PaneScene.paneroom.roomname = ServerSelectScene.serverselectcontroller.rooom8.getText();
        PaneScene.paneroom.textarea.setText("");
        Server_ControlMessage.showmain();
            stage.setScene(pane.getScene());
            break;
        case Scene9:
        PaneScene.paneroom.firstcheck = true;
        PaneScene.paneroom.roomname = ServerSelectScene.serverselectcontroller.rooom9.getText();
        PaneScene.paneroom.textarea.setText("");
        Server_ControlMessage.showmain();
            stage.setScene(pane.getScene());
            break;
        case Scene10:
        PaneScene.paneroom.firstcheck = true;
        PaneScene.paneroom.roomname = ServerSelectScene.serverselectcontroller.rooom10.getText();
        PaneScene.paneroom.textarea.setText("");
        Server_ControlMessage.showmain();
            stage.setScene(pane.getScene());
            break;

        case AddThema:
            stage.setScene(putroomscene.getScene());
            break;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
