import java.util.*;

public class Room{
    public String room_name;
    public ArrayList<String> messlist;// 投稿文字の保持

    public Room(String room_name){
        this.room_name = room_name; 
        if (messlist == null) {
            messlist = new ArrayList<String>();//その部屋毎のリストを用意
        }
    }
    
}
