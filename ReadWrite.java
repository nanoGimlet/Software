// package sample;

// �����buffered�Ƃ�printwriter�������ɋ��ʂ̍�Ƃ������̂ł܂Ƃ߂��N���X
// in�ɂ͑����Ă�����������Ă�Bout�ɂ͑��肽���������B
// �܂�Client���ł�out�ɂ������Server�ɁBServer��in�ɓ����Ă�̂�Client���瑗���Ă�����B


import java.io.*;
import java.net.Socket;

public class ReadWrite {
    private Socket soc;
    public BufferedReader in;
    public PrintWriter out;

    public ReadWrite(Socket sct) throws IOException {
        soc = sct;
        in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())), true);
    }
}
