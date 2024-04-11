package ru.dmitruk.threadTasks.task2.join;

import java.util.Map;

import static ru.dmitruk.threadTasks.task2.PrintWordStatistic.printThreadWordResult;

public class ThreadRepeatableWordsCounter implements Runnable {

    private String filePath;
    private Map<String, Integer> wordsAndRepeatedNumbers;
    private Map<String, Integer> allFilesWordsAndRepeatedNumbers;


    public ThreadRepeatableWordsCounter(
            String filePath, Map<String, Integer> allFilesWordsAndRepeatedNumbers
    ) {
        this.filePath = filePath;
        this.allFilesWordsAndRepeatedNumbers = allFilesWordsAndRepeatedNumbers;
    }

    @Override
    public void run() {
        RepeatableWordsCounter counter = new RepeatableWordsCounter();
        wordsAndRepeatedNumbers = counter.count(
                filePath, allFilesWordsAndRepeatedNumbers);

        System.out.println("\n" + Thread.currentThread().getName() + " WORD'S STATISTIC");
        printThreadWordResult(wordsAndRepeatedNumbers);
    }


    public Map<String, Integer> getWordsAndRepeatedNumbers() {
        return wordsAndRepeatedNumbers;
    }
}
