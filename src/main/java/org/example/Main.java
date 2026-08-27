package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);

        //C:\Users\iamdu\Documents\test.txt
        System.out.println("Skriv inn stien til din txt fil");
        String pathString = scanner.nextLine();
        Path path = Path.of(pathString);

        try {

            List<String> lines = Files.readAllLines(path);
            List<LogEntry> logEntries = new ArrayList<>();
            int countLines = lines.size();
            System.out.println("Loaded " + countLines + " log lines.");

            for (String logs: lines){
                String[] parts = logs.split(" ", 4);
                String date = parts[0];
                String time = parts[1];
                String level = parts[2].replace("[","").replace("]","");
                String message = parts[3];

                LogEntry entry = new LogEntry(date,time,level,message);
                logEntries.add(entry);
                /*System.out.println("Date: " + date + "\n" +
                        "Time: " + time + "\n" +
                        "Level: " + level + "\n" +
                        "Message: " + message);*/
            }

            List<LogEntry> errorLogs = new ArrayList<>();
            for (LogEntry log : logEntries){
                if (log.getLevel().equals("ERROR")){
                    errorLogs.add(log);
                }
            }
            for (LogEntry error : errorLogs){
                String errorMessage = error.getMessage();
                System.out.println(errorMessage);
            }
            System.out.println(errorLogs.size());
            System.out.println(logEntries.size());
        } catch (IOException e){
            System.out.println("tekst filen finnes ikke");

        }


    }
}