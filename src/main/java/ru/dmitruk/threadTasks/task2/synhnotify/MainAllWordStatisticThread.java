package ru.dmitruk.threadTasks.task2.synhnotify;

import java.util.Map;

import static ru.dmitruk.threadTasks.task2.PrintWordStatistic.printThreadWordResult;
import static ru.dmitruk.threadTasks.task2.synhnotify.Task2Synchronized.MONITOR;

public class MainAllWordStatisticThread implements Runnable {

    private Map<String, Integer> allFilesWordsAndRepeatedNumbers;

    MainAllWordStatisticThread(Map<String, Integer> allFilesWordsAndRepeatedNumbers) {
        this.allFilesWordsAndRepeatedNumbers = allFilesWordsAndRepeatedNumbers;
    }


    @Override
    public void run() {
        synchronized (MONITOR) {
            try {
                MONITOR.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("\nALL FILES WORD'S STATISTIC: ");
        printThreadWordResult(allFilesWordsAndRepeatedNumbers);
    }
}
