package ru.dmitruk.threadTasks.task1.join;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordsCounter {

    public static int count(String filePath) {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                count = count + line.split(" ").length;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return count;
    }
}
