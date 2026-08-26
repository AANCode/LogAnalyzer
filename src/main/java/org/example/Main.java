package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
            int countLines = lines.size();
            System.out.println("Loaded " + countLines + " log lines.");

            for (String logs: lines){
                String[] parts = logs.split(" ", 4);
                System.out.println("Date: " + parts[0]);
                System.out.println("Time: " + parts[1]);
                System.out.println("Level: " + parts[2].replace("[","").replace("]",""));
                System.out.println("Message: " + parts[3]);
            }
        } catch (IOException e){
            System.out.println("tekst filen finnes ikke");

        }


    }
}