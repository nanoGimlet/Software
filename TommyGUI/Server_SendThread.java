
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
        // String name = PutRoomScene.putroom.roomname.getText();
        // System.out.println(ChatServer.chatroom_name.size()+"putname");デバック用
        // ChatServer.addmap(name);// 新しい名前の追加
        // sc.close();
        return true;
    }

    public boolean PutName(String oldname) {// 自動生成用（投稿数があふれた時の部屋の自動生成）
        if (ChatServer.chatroom_name.size() >= maxroomsize) {
            System.out.println("部屋の数が上限に達しました。入力できません");
            return false;
        }
        String scan = oldname.substring(oldname.length() - 1);// 添え字取得
        String newchatroom = oldname;// 新しい部屋名のための変数
        int num = 1;// 添え字更新のため
        try {// scanが数字なら数字の変換
            num = Integer.parseInt(scan);
            System.out.println(num);
            newchatroom = oldname.substring(0, oldname.length() - 1);// 添え字なしで新しい部屋名の作成
        } catch (NumberFormatException e) {
            // ないなら何もしない

        }
        String number = String.valueOf(num + 1);// 添え字の更新
        ChatServer.addmap(newchatroom + number);// 添え字をつけた新しい部屋名を用いて、新しい部屋を追加
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