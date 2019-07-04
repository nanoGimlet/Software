//�N���C�A���g�T���v���v���O����
//�T�[�o�[�ɐڑ����A���b�Z�[�W�𑗐M����B
//�T�[�o�[�A�h���X�̓R�}���h���C���̑�1�����Ŏw��B
//�|�[�g��30000�ɌŒ�B���MultiServerSample���N�����Ă������ƁB
//��2�����ŁA���b�Z�[�W���w�肷��B��s�����ăT�[�o�[�����
//���b�Z�[�W��M�C�\����Ƀv���O�����I������B
//�R�}���h���C����Fjava MultiClientSample localhost abcdefg

import java.net.*;
import java.io.*;

class MultiClientSample 
{
    public static void main(String[] args)
    {
        try {
        
    //�A�h���X����ێ�����socketAddress���쐬�B
    //�|�[�g�ԍ���30000
        InetSocketAddress socketAddress = 
            new InetSocketAddress(args[0], 30000);
            
    //socketAddress�̒l�Ɋ�Â��ĒʐM�Ɏg�p����\�P�b�g���쐬����B

    //
        Socket socket = new Socket();
    //�^�C���A�E�g��10�b(10000msec)
        socket.connect(socketAddress, 10000);

    //�ڑ���̏�������InetAddress�^��inadr��p�ӂ���B
        InetAddress inadr;

    //inadr�Ƀ\�P�b�g�̐ڑ���A�h���X�����Anull�ł���ꍇ�ɂ�
    //�ڑ����s�Ɣ��f����B
    //null�łȂ���΁A�ڑ��m�����Ă���B
        if ((inadr = socket.getInetAddress()) != null) {
            System.out.println("Connect to " + inadr);
        }else {
            System.out.println("Connection failed.");
            return;
        }

    //���b�Z�[�W�̑��M����
    //�R�}���h���C��������2�Ԗڂ����b�Z�[�W�Ƃ���B
        String message = args[1];

    //PrintWriter�^��writer�ɁA�\�P�b�g�̏o�̓X�g���[����n���B(Auto Flush)
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
    //�\�P�b�g�̓��̓X�g���[����BufferedReader�ɓn���B
        BufferedReader rd = new BufferedReader(
           new InputStreamReader( socket.getInputStream()));

        System.out.println("Send message: " + message);

    //�\�P�b�g����o�͂���B
        writer.println(message);
    //����PrintWriter��AutoFlush�łȂ��ꍇ�́C�ȉ����K�v�B
    //  writer.flush();

    //�T�[�o�[����̃��b�Z�[�W�ǂݎ��
        String getline=rd.readLine();
        System.out.println("Message from Server:" + getline);

    //�I������
            writer.close();
            socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    } 
}