package ru.dmitruk.threadTasks.task1.join;

public class ThreadWordsCounter implements Runnable {

    private String fileName;
    private int wordsNumber;

    public ThreadWordsCounter(String fileName) {
        this.fileName = fileName;
        wordsNumber = 0;
    }

    @Override
    public void run() {
        wordsNumber = WordsCounter.count(fileName);
        System.out.println("Number of words present in given file: " + wordsNumber);

    }

    public int getWordsNumber() {
        return wordsNumber;
    }
}
