package ru.dmitruk.threadTasks.task2.synhnotify;


import java.util.HashMap;
import java.util.Map;


public class Task2Synchronized {

    private Map<String, Integer> wordsAndRepeatableNumbers;

    public static final Object MONITOR = new Object();

    public Task2Synchronized() {
        wordsAndRepeatableNumbers = new HashMap<>();
    }

    public  void countWordsNumbers(String[] filePaths) {
        MainAllWordStatisticThread mainAllWordStatisticThread =
                new MainAllWordStatisticThread(wordsAndRepeatableNumbers);
        Thread thread = new Thread(mainAllWordStatisticThread);
        thread.start();
        System.out.println("aaaaaa");

        for (String filaPath : filePaths) {
            startNewThread(filaPath);
        }
    }

    private void startNewThread(String filePath)  {
        FileWordStatisticThread threadWordsCounter = new FileWordStatisticThread(
                filePath, wordsAndRepeatableNumbers
        );
        Thread thread = new Thread(threadWordsCounter);
        thread.start();
    }
}
