
//元SendThreadのサーバー側

import java.util.*;

class Server_SendThread extends Thread {

    public static final int maxroomsize = 10;// 部屋数制限

    public Server_SendThread() {
        this.start();
    }

    public boolean PutName() {// 任意の部屋名入力のための関数
        if (ChatServer.chatroom_name.size() >= maxroomsize) {// 部屋数上限の制限
            System.out.println("部屋の数が上限に達しました。入力できません");
            return false;
        }
        return true;
    }

    @Override
    public void run() {

        try {
            System.out.println(currentThread());
            while (PutName()) {// 上限に達するまで入力待ち
                // Scanner sc1 = new Scanner(System.in);
                // String mess = sc1.nextLine();
                // ChatServer.addmap(mess);// 新しい名前の追加
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}