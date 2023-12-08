package reseau;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {

    private String name;
    private String message;
    private String toWho;
    
    public ArrayList<String> onlineUsers =new ArrayList<String>();

    public Message(String name, String message, String toWho) {
        this.name = name;
        this.message = message;
        this.toWho = toWho;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
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