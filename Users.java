package com.example.eventmanagementprojectformygroup;

import java.util.Date;

public class Users {


    String userName,email,EventName,timeduration,date;

    public Users() {
    }

    public Users(String userName, String email, String EventName, String timeduration, String date) {
        this.userName = userName;
        this.email = email;
        this.EventName = EventName;
        this.timeduration = timeduration;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getTimeduration() {
        return timeduration;
    }

    public void setTimeduration(String timeduration) {
        this.timeduration = timeduration;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

