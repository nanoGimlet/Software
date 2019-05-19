//�����ڑ�Socket�ʐM�T���v���v���O����(�T�[�o�[)
//�N���C�A���g����̐ڑ���҂��A�ڑ����s�Ȃ�ꂽ��
//1�s�̃f�[�^���󂯎��A�R���\�[���ɕ\�����Đڑ���ؒf����B
//�����̃N���C�A���g�Ƃ̒ʐM���X���b�h�ɂ��s�Ȃ��B
//�v���O�����I���́C�R�}���h�v�����v�g��CTRL-C
import java.net.*;
import java.io.*;

class MultiServerSample 
{
  public static void main(String[] args){
      ServerSocket serverSoc = null;
      try {
        // �|�[�g�ԍ��́A30000
        //�\�P�b�g���쐬
        serverSoc = new ServerSocket(30000);
        boolean flag=true;
      
        //�N���C�A���g����̐ڑ���ҋ@����accept()���\�b�h�B
        //accept()�́A�ڑ�������܂ŏ����̓u���b�N�����B
        //�����A�����̃N���C�A���g����̐ڑ����󂯕t����悤�ɂ���ɂ�
        //�X���b�h���g���B
        //accept()�͐ڑ����ɐV����socket��Ԃ��B������g���ĒʐM���s�Ȃ��B
        System.out.println("Waiting for Connection. ");
        while(flag){
          Socket socket=null;
          socket = serverSoc.accept();
          //accept()�́A�N���C�A���g����̐ڑ��v��������܂Ńu���b�N����B
          //�ڑ�������Ύ��̖��߂Ɉڂ�B
          //�X���b�h���N�����A�N���C�A���g�ƒʐM����B
          new SrvThread(socket).start();
          System.out.println("Waiting for New Connection. ");
        }
      }
      catch (IOException e) {
        System.out.println("IOException!");
        e.printStackTrace();
      }
      finally{
        try{
          if (serverSoc != null){
            serverSoc.close();
          }
        }
        catch (IOException ioex) {
          ioex.printStackTrace();
        }
      }
   }
}

class SrvThread extends Thread{
  private Socket soc;

  public SrvThread(Socket sct){
    soc=sct;
    System.out.println("Thread is Generated.  Connect to " +
        soc.getInetAddress());
  }

  public void run(){
    try{
      //socket����̃f�[�^��InputStreamReader�ɑ���A�����
      //BufferedReader�ɂ���ăo�b�t�@�����O����B
      BufferedReader reader = new BufferedReader
        (new InputStreamReader(soc.getInputStream()));
      //Client�ւ̏o�͗pPrintWriter
      PrintWriter sendout = new PrintWriter(soc.getOutputStream(), true);
      //�f�[�^�ǂݎ��ƕ\���B
      String line;
      line = reader.readLine();
      System.out.println("Message from client :" + line);
      //Client�Ƀ��b�Z�[�W���M
      sendout.println("Message is received.");
    }
    catch(IOException ioex){
      ioex.printStackTrace();
    }
    finally{
      try{
        if(soc != null){
          soc.close();
        }
      }
      catch (IOException ioex){
        ioex.printStackTrace();
      }
    }
  }
}