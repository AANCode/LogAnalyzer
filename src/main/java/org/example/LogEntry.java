package org.example;

public class LogEntry {
    private final String date;
    private final String time;
    private final String level;
    private final String message;

    public LogEntry(String date, String time, String level, String message){
        this.date = date;
        this.time = time;
        this.level = level;
        this.message = message;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }

    public String getLevel(){
        return level;
    }

    public String getMessage(){
        return message;
    }
}
