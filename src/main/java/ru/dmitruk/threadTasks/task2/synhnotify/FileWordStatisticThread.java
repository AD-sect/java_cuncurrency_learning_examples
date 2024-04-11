package ru.dmitruk.threadTasks.task2.synhnotify;


import java.util.Map;

import static ru.dmitruk.threadTasks.task2.PrintWordStatistic.printThreadWordResult;
import static ru.dmitruk.threadTasks.task2.synhnotify.Task2Synchronized.MONITOR;

public class FileWordStatisticThread implements Runnable {

    private String filePath;
    private Map<String, Integer> allFilesWordsAndRepeatedNumbers;


    public FileWordStatisticThread(
            String filePath, Map<String, Integer> allFilesWordsAndRepeatedNumbers
    ) {
        this.filePath = filePath;
        this.allFilesWordsAndRepeatedNumbers = allFilesWordsAndRepeatedNumbers;
    }

    @Override
    public void run() {
        RepeatableWordsCounter counter = new RepeatableWordsCounter();

        synchronized (MONITOR) {
            System.out.println("\n" + Thread.currentThread().getName() + " WORD'S STATISTIC");
            printThreadWordResult(counter.count(filePath, allFilesWordsAndRepeatedNumbers));
        }
        notifyMainThread();
    }

    public void notifyMainThread() {
        synchronized (MONITOR) {
            MONITOR.notify();
        }
    }

}
