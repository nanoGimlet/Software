import java.io.*;
import java.net.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Room{
    public String room_name;
    public List<Connect> client_list;
    BlockingQueue<String> queue;// キューの宣言
    public void addclient(Connect client){
        client_list.add(client);
    }
    public void removeclient(Connect client){
        client_list.remove(client);
    }

    public Room(String room_name){
        this.room_name = room_name; 
        if (queue == null) {
            queue = new LinkedBlockingQueue<String>(500);// キューに追加できる要素の最大数を５０個にする
        }
    }
    
}
