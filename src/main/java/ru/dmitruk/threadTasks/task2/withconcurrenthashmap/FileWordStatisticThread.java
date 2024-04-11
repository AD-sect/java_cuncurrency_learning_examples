package ru.dmitruk.threadTasks.task2.withconcurrenthashmap;


import java.util.Map;

import static ru.dmitruk.threadTasks.task2.withconcurrenthashmap.Task2Parallel.latch;


public class FileWordStatisticThread implements Runnable {

    private String filePath;
    private Map<String, Integer> allFilesWordsAndRepeatedNumbers;

    public FileWordStatisticThread(String filePath, Map<String, Integer> allFilesWordsAndRepeatedNumbers) {
        this.filePath = filePath;
        this.allFilesWordsAndRepeatedNumbers = allFilesWordsAndRepeatedNumbers;
    }

    @Override
    public void run() {
        RepeatableWordsCounter counter = new RepeatableWordsCounter();
        counter.count(filePath, allFilesWordsAndRepeatedNumbers);
        latch.countDown();
    }
}
