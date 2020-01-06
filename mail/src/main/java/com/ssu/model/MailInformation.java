package com.ssu.model;

import java.util.ArrayList;

public class MailInformation {

    private String theme;
    private String message;
    private ArrayList<String> toEmails;
    private String fromEmail;

    public MailInformation(){}

    public MailInformation(String theme, String message, ArrayList<String> toEmails, String fromEmail){
        this.theme = theme;
        this.message = message;
        this.toEmails = toEmails;
        this.fromEmail = fromEmail;
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

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }
}
