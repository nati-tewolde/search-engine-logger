package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        userLog("launch");

        Scanner input = new Scanner(System.in);

            boolean isRunning = true;
            while (isRunning) {
                System.out.print("Enter a search term (X to exit): ");
                String searchTerm = input.nextLine();

                if (searchTerm.equalsIgnoreCase("X")){
                    userLog("exit");
                    isRunning = false;
                } else {
                    userLog("search: " + searchTerm);
                }
            }

            input.close();

        }


    public static void userLog(String action) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true));
            writer.write(formatter.format(LocalDateTime.now()) + " " + action);
            writer.newLine();
            writer.close();
        } catch (IOException ex) {
            System.err.println("Error writing to file.");;
        }


    }
}
