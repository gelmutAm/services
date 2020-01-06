package com.ssu.model;

import java.util.ArrayList;

public class MailInformation {

    private String theme;
    private String message;
    private ArrayList<String> toEmails;
    private final String fromEmail = "your_blog@blog.ru";

    public MailInformation(){}

    public  MailInformation(String theme, String message, ArrayList<String> toEmails){
        this.theme = theme;
        this.message = message;
        this.toEmails = toEmails;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<String> getToEmails() {
        return toEmails;
    }

    public void setToEmails(ArrayList<String> toEmails) {
        this.toEmails = toEmails;
    }

    public String getFromEmail() {
        return fromEmail;
    }
}
