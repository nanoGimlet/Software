import java.util.*;

public class Room{
    public String room_name;
    public List<Connect> client_list;
    public ArrayList<String> messlist;// 投稿文字の保持

    // これ別のクラスで持ち直した方がいんじゃね？

    /*public void addclient(Connect client){
        client_list.add(client);
    }*/
    /*public void removeclient(Connect client){
        client_list.remove(client);
    }*/

    public Room(String room_name){
        this.room_name = room_name; 
        if (messlist == null) {
            messlist = new ArrayList<String>();//その部屋毎のリストを用意
        }
    }
    
}
