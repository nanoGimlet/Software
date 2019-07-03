import java.io.*;
import java.net.Socket;
import java.util.*;

class Server_ControlMessage extends Thread {
    public static int no = 1;
    public static final int PORT = 19190;
    static List<Server_ControlMessage> threads;
    Socket socket;
    String chatroom_name;
    Server_SendThread send;// 部屋名入力のためのスレッド

    public static final int maxsize = 10;// メッセージ数の上限

    public Server_ControlMessage(Socket sct, Server_SendThread send) {
        super();
        this.send = send;

        socket = sct;
        if (threads == null) {
            threads = new ArrayList<Server_ControlMessage>();
        }
        threads.add(this);
        this.start();
    }

    @Override
    public void run() {
        try {

            System.err.println(currentThread());
            System.err.println("*** Connected ***");
            while (true) {
                try {
                    ReaderWriter RWserver = new ReaderWriter(socket);
                    String mess = RWserver.in.readLine();
                    Scanner sc = new Scanner(mess);
                    chatroom_name = sc.next();
                    if (sc.hasNext()) {// 空白の後に後に文字があるかどうか
                    } else {
                        show_list(socket, chatroom_name);
                        continue;
                    }
                    // if (ChatServer.list.get(chatroom_name).messlist.size() >= 500) {//
                    // 51個目がきたらポップして最新版にする
                    // }

                    // System.out.println("mess : " + mess);
                    if (mess == null) {
                        socket.close();
                        threads.remove(this);
                        return;
                    }

                    PrintSplit ps = new PrintSplit(mess);
                    chatroom_name = ps.PrintRoom;
                    if (ChatServer.list.get(chatroom_name).messlist.size() >= maxsize) {
                        System.out.println("容量の上限に達しました");
                        // Scanner sc1 = new Scanner(System.in);
                        // String name = sc1.nextLine();
                        // ChatServer.addmap(name);// 添え字をつけた新しい部屋名を用いて、新しい部屋を追加
                        //send.PutName(chatroom_name);

                        String newname = chatroom_name;
                        String scan = chatroom_name.substring(chatroom_name.length() - 1);// 添え字取得
                        int num = 1;// 添え字更新のため
                        try {// scanが数字なら数字の変換
                            num = Integer.parseInt(scan);
                            System.out.println(num);
                            newname = chatroom_name.substring(0, chatroom_name.length() - 1);// 添え字なしで新しい部屋名の作成
                        } catch (NumberFormatException e) {
                            // ないなら何もしない

                        }
                        String number = String.valueOf(num + 1);// 添え字の更新
                        newname = newname + number;// 添え字をつけた新しい部屋名を用いて、新しい部屋を追加
                        try {
                            switch (PutRoomScene.putroom.count) {
                            case 1:
                                ServerSelectScene.serverselectcontroller.rooom1.setVisible(true);
                                ServerSelectScene.serverselectcontroller.rooom1.setText(newname);
                                PutRoomScene.putroom.count++;
                                break;
                            case 2:
                                ServerSelectScene.serverselectcontroller.rooom2.setVisible(true);
                                ServerSelectScene.serverselectcontroller.rooom2.setText(newname);
                                PutRoomScene.putroom.count++;
                                break;
                            case 3:
                                ServerSelectScene.serverselectcontroller.rooom3.setVisible(true);
                                ServerSelectScene.serverselectcontroller.rooom3.setText(newname);
                                PutRoomScene.putroom.count++;
                                break;
                            case 4:
                                ServerSelectScene.serverselectcontroller.rooom4.setVisible(true);
                                ServerSelectScene.serverselectcontroller.rooom4.setText(newname);
                                PutRoomScene.putroom.count++;
                                break;
                            case 5:
                                ServerSelectScene.serverselectcontroller.rooom5.setVisible(true);
                                ServerSelectScene.serverselectcontroller.rooom5.setText(newname);
                                PutRoomScene.putroom.count++;
                                break;
                            case 6:
                                ServerSelectScene.serverselectcontroller.rooom6.setVisible(true);
                                ServerSelectScene.serverselectcontroller.rooom6.setText(newname);
                                PutRoomScene.putroom.count++;
                                break;
                            case 7:
                                ServerSelectScene.serverselectcontroller.rooom7.setVisible(true);
                                ServerSelectScene.serverselectcontroller.rooom7.setText(newname);
                                PutRoomScene.putroom.count++;
                                break;
                            case 8:
                                ServerSelectScene.serverselectcontroller.rooom8.setVisible(true);
                                ServerSelectScene.serverselectcontroller.rooom8.setText(newname);
                                PutRoomScene.putroom.count++;
                                break;
                            case 9:
                                ServerSelectScene.serverselectcontroller.rooom9.setVisible(true);
                                ServerSelectScene.serverselectcontroller.rooom9.setText(newname);
                                PutRoomScene.putroom.count++;
                                break;
                            case 10:
                                ServerSelectScene.serverselectcontroller.rooom10.setVisible(true);
                                ServerSelectScene.serverselectcontroller.rooom10.setText(newname);
                                PutRoomScene.putroom.count++;
                                break;
                            }
                            ChatServer.chatroom_name.add(newname);
                            ChatServer.list.put(newname, new Room(newname));
                            Server_SendThread chatname = new Server_SendThread();
                            System.out.println(ChatServer.chatroom_name.toString());
                        } catch (Exception e) {
                            System.out.println("これはおかしい");
                        }
                        PutRoomScene.putroom.count++;
                        String message = "err投稿数が" + maxsize + "件を超えました。";
                        PrintSplit ps2 = new PrintSplit(chatroom_name, message, ps.Printday);
                        talk(ps2.Sendform());
                    } else {
                        PrintSplit receive2 = new PrintSplit(mess);
                        ChatServer.list.get(chatroom_name).messlist.add(mess);// リストに日付の保存

                        // ChatServer.list.get(chatroom_name).messlist.add(receive2.Printcontent+receive2.Printnewday);//
                        // リストに日付の保存

                        // ChatServer.list.get(chatroom_name).messlist.add(receive2.Printcontent+receive2.Printnewday);//
                        // リストに日付の保存
                        // ChatServer.list.get(chatroom_name).messlist.add(receive2.Printnewday);

                        System.out.println(mess);
                        // System.out.println(receive2.Printcontent);
                        // System.out.println(receive2.Printnewday);
                        if (receive2.PrintRoom.equals(PaneScene.paneroom.roomname)) {
                            PaneScene.paneroom.textarea
                                    .appendText(no + " " + receive2.Printcontent + "\n" + receive2.Printnewday + "\n");
                            no++;
                        } else
                            System.out.println("damejan");
                        // PaneScene.paneroom.textarea.appendText(receive2.Printcontent);
                        // PaneScene.paneroom.textarea.appendText(receive2.Printnewday);
                        // System.out.println(mess);// mess=全部
                        // PaneScene.paneroom.textarea.appendText(mess);
                        talk(mess);
                    }
                } catch (IOException e) {
                    System.err.println("*** Connection closed ***");
                    socket.close();
                    threads.remove(this);
                    return;
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    // これが新規ユーザーが来た時の履歴の出力
    public static void show_list(Socket socket, String chatroom_name) {
        try {
            ReaderWriter out_message = new ReaderWriter(socket);
            out_message.out.println(ChatServer.list.get(chatroom_name).messlist.toString());
        } catch (Exception e) {

        }
    }

    public static void show_log(String text) {
        no = 1;
        String tmp = text.substring(1, text.length() - 1);
        String showmess[] = tmp.split(", ");
        for (String mess : showmess) {
            PrintSplit pslog = new PrintSplit(mess);
            System.out.println(showmess.length);
            PaneScene.paneroom.textarea.appendText(no + " ");
            PaneScene.paneroom.textarea.appendText(pslog.Printcontent + "\n");
            PaneScene.paneroom.textarea.appendText(pslog.Printnewday + "\n");
            no++;
        }

    }

    public static void showmain() {
        if (PaneScene.paneroom.firstcheck) {
            System.out.println("first");
            try {
                Server_ControlMessage.show_log(ChatServer.list.get(PaneScene.paneroom.roomname).messlist.toString());
            } catch (Exception e) {
            }
            PaneScene.paneroom.firstcheck = false;
        }
    }

    public void talk(String str) {
        for (int i = 0; i < threads.size(); i++) {
            Server_ControlMessage st = threads.get(i);
            if (st.isAlive()) {
                System.out.println("送信 : " + chatroom_name);
                st.show(str);
            }
        }
    }

    public void show(String str) {
        try {
            ReaderWriter RWs = new ReaderWriter(socket);
            RWs.out.println(str);
            RWs.out.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
