import javafx.fxml.FXMLLoader;

public class showOnList extends Thread {
    public showOnList(){
        this.start();
    }

    public void run() {
        try {
            Controller.number = Controller.controlMessage.getNo();
            Controller.strText = Controller.controlMessage.getContent();
            Controller.data = Controller.controlMessage.getDay();
            System.out.println("@Controller now:" + Controller.getStrText());
            Controller.talkPane = FXMLLoader.load(getClass().getResource("talkPane.fxml"));
            Controller.ObservableList1.add(Controller.talkPane);
        }catch (Exception e){}
        }

}