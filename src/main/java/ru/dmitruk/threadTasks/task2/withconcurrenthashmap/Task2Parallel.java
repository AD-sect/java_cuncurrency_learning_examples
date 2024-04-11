package ru.dmitruk.threadTasks.task2.withconcurrenthashmap;

import ru.dmitruk.threadTasks.task2.PrintWordStatistic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;


public class Task2Parallel {

    private Map<String, Integer> wordsAndRepeatableNumbers;

    public static CountDownLatch latch;
    public Task2Parallel(int fileNumber) {
        wordsAndRepeatableNumbers = new ConcurrentHashMap<>();
        latch = new CountDownLatch(fileNumber);
    }

    public  void countWordsNumbers(String[] filePaths) {
        try {
            for (String filaPath : filePaths) {
                startNewThread(filaPath);
            }
            latch.await();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        printThreadWordResult(wordsAndRepeatableNumbers);
    }

    private void startNewThread(String filePath)  {
        FileWordStatisticThread threadWordsCounter = new FileWordStatisticThread(
                filePath, wordsAndRepeatableNumbers
        );
        Thread thread = new Thread(threadWordsCounter);
        thread.start();
    }

    public void printThreadWordResult(Map<String, Integer> wordsAndRepeatedNumbers) {
        PrintWordStatistic.printThreadWordResult(wordsAndRepeatedNumbers);
    }
}
