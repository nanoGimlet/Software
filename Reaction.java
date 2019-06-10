import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Reaction extends Thread {
    private Socket soc = null;

    public Reaction(Socket sct) {
        soc = sct;
    }

    @Override
    public void run() {
        if (soc != null && soc.isConnected()) {
            ReaderWriter RWc = null;
            try {
                while (true) {
                    RWc = new ReaderWriter(soc);
                    Scanner sc = new Scanner(System.in);
                    String str = sc.nextLine();
                    while (str.length() > 50) {
                        System.err.println("50文字以内で入力してください。現在入力数：" + str.length());
                        str = sc.nextLine();
                    }
                    RWc.out.println(str);
                    RWc.out.flush();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        } else {
            System.out.println("NOT CONNECTED");
        }
    }
}