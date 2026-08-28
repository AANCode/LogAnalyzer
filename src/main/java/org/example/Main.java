package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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
            int lineCount = lines.size();
            System.out.println("Loaded " + lineCount + " log lines.");

            for (String logLine: lines){
                String[] parts = logLine.split(" ", 4);
                String date = parts[0];
                String time = parts[1];
                String level = parts[2].replace("[","").replace("]","");
                String message = parts[3];

                LogEntry entry = new LogEntry(date,time,level,message);
                logEntries.add(entry);
            }

            List<LogEntry> errorLogs = new ArrayList<>();
            for (LogEntry logLine : logEntries){
                if (logLine.getLevel().equals("ERROR")){
                    errorLogs.add(logLine);
                }
            }
            for (LogEntry error : errorLogs){
                String errorMessage = error.getMessage();
                System.out.println(errorMessage);
            }


            Map<String, Integer> levelCounts = new HashMap<>();
            for (LogEntry logLine : logEntries){
                String level = logLine.getLevel();
                levelCounts.put(level, levelCounts.getOrDefault(level, 0)+1);
            }
            System.out.println(levelCounts);

        } catch (IOException e){
            System.out.println("tekst filen finnes ikke");

        }


    }
}