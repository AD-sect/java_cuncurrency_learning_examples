package ru.dmitruk.threadTasks.task2.synhnotify;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RepeatableWordsCounter {

    public  Map<String, Integer> count(
            String filePath,
            Map<String, Integer> allFilesWordsAndRepeatedNumbers
    ) {
        Map<String, Integer> threadWordsAndRepeatedNumbers = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                addWordsFromLineIntoMap(line, threadWordsAndRepeatedNumbers);
                addWordsFromLineIntoMap(line, allFilesWordsAndRepeatedNumbers);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return threadWordsAndRepeatedNumbers;
    }

    public void addWordsFromLineIntoMap(String line, Map<String, Integer> wordsAndRepeatedNumbers) {
        Arrays.stream(line.split(" "))
                .forEach(word -> putWordIntoMap(word, wordsAndRepeatedNumbers));
    }

    public void putWordIntoMap(String word, Map<String, Integer> wordsAndRepeatedNumbers) {
        if (wordsAndRepeatedNumbers.containsKey(word)) {
            wordsAndRepeatedNumbers.computeIfPresent(word, (wordKey, number) -> number + 1);
        } else {
            wordsAndRepeatedNumbers.put(word, 1);
        }
    }

}
