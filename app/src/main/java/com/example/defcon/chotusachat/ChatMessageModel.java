package com.example.defcon.chotusachat;

/**
 * Created by DEFCON on 7/31/2016.
 */
public class ChatMessageModel {
    private String name;
    private String message;

    public ChatMessageModel() {

    }

    public ChatMessageModel(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
