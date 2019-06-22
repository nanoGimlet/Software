import javafx.application.Application;
import java.io.IOException; //
import java.net.InetAddress; //
import java.net.Socket; //
import java.util.*; //
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;

import javafx.stage.Stage;

public class Mainapp extends Application{
    public static int PORT; //
    @Override
    public void start(Stage primaryStage) throws Exception {


        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("portConnect.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        /*
        String server = InetAddress.getLocalHost().getHostAddress();
        //Scanner scp = new Scanner(System.in);
        PORT = portController.getPort();
        System.out.println("PORT:"+PORT);
        Socket socket = null;
        try {
            InetAddress addr = InetAddress.getByName(server);
            socket = new Socket(addr, PORT);
            Connect con = new Connect();
            con.connect(socket);
        } catch (IOException e) {

        }
        */
    }

    public static void main(String[] args) throws IOException {
        launch(args);
        //
        String server = InetAddress.getLocalHost().getHostAddress();
        //Scanner scp = new Scanner(System.in);
        PORT = portController.getPort();
        System.out.println("port:"+PORT);
        Socket socket = null;
        try {
            InetAddress addr = InetAddress.getByName(server);
            socket = new Socket(addr, PORT);
            Connect con = new Connect();
            con.connect(socket);
        } catch (IOException e) {

        }
       //
    }
}
