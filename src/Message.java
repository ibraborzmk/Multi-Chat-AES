import javax.crypto.SecretKey;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {

    private String name;
    private byte[] message;
    private String toWho;
    private SecretKey key ;
    
    public ArrayList<String> onlineUsers =new ArrayList<String>();

    public Message(String name, byte[] message, String toWho, SecretKey key) {
        this.name = name;
        this.message = message;
        this.toWho = toWho;
        this.key = key ;
    }

    public String getName() {
        return name;
    }

    public SecretKey getKey(){return  key;};

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getMessage() {
        return message;
    }

    public void setMessage(byte[] message) {
        this.message = message;
    }


    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }


    public void addOnlineUser(String s){
        this.onlineUsers.add(s);
    }

    public ArrayList getOnlineUsers(){
        return this.onlineUsers;
    }

    public void setOnlineUsers(ArrayList l){
        onlineUsers =new ArrayList<>();
        onlineUsers.addAll(l);
    }


    public String toString() {
        return this.name + ": " + this.message;
    }
}