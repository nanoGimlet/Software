// Threadã‚’ç”Ÿæˆã™ã‚‹ãŸã‚ã ã‘ã?®ã‚¯ãƒ©ã‚¹

import java.net.*;
import java.io.*;

class ServerThread extends Thread{
    private Socket soc;

    public ServerThread(Socket sct){
        soc = sct;
        System.out.println("Thread is Generated. Connect to " + soc.getInetAddress());
    }

    @Override
    public void run(){
        try {    
            System.out.println(Thread.currentThread());     // Thread‚ğŠm”F‚·‚é‚½‚ß‚Ì‚à‚Ì
            BufferedReader reader = new BufferedReader
            (new InputStreamReader(soc.getInputStream()));

            PrintWriter sendout = new PrintWriter
            (new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);

            while(true){
                String line = reader.readLine();
                if(line.equals("END")) break;
                System.out.println(line);
            }
        } catch(IOException ioex) {
            ioex.printStackTrace();
        } finally {
            System.out.println("closing...");
            try{
                soc.close();
            } catch (IOException ie){
                ie.printStackTrace();
            }
        }
    }
}