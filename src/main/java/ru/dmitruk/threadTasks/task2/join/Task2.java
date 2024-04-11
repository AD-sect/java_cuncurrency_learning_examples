package ru.dmitruk.threadTasks.task2.join;


import java.util.HashMap;
import java.util.Map;

import static ru.dmitruk.threadTasks.task2.PrintWordStatistic.printThreadWordResult;

public class Task2 {

    private Map<String, Integer> wordsAndRepeatableNumbers;

    public Task2() {
        wordsAndRepeatableNumbers = new HashMap<>();
    }

    public void countWordsNumbers(String[] filePaths) {
        for (String filaPath : filePaths) {
            startNewThread(filaPath);
        }
        System.out.println("\nALL FILES WORD'S STATISTIC: ");
        printThreadWordResult(wordsAndRepeatableNumbers);
    }

    private void startNewThread(String filePath) {
        try {
            ThreadRepeatableWordsCounter threadWordsCounter = new ThreadRepeatableWordsCounter(
                    filePath, wordsAndRepeatableNumbers
            );
            Thread thread = new Thread(threadWordsCounter);
            thread.start();
            thread.join();
        } catch (
                InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
