package co.com.example.Models;

import java.util.Date;

public class MessageModel {

    private String id;
    private String message;

    public MessageModel() {
        this.id = this.generateId();
    }

    public MessageModel(String message) {
        this.id = this.generateId();
        this.message = message;
    }

    private String generateId(){
        int i = (int) (new Date().getTime()/1000);
        return Integer.toString(i);
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
