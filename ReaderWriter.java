import java.io.*;
import java.net.Socket;

public class ReaderWriter {
    private Socket soc;
    public BufferedReader in;
    public PrintWriter out;

    public ReaderWriter(Socket sct) throws IOException {
        soc = sct;
        in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
    }
}
