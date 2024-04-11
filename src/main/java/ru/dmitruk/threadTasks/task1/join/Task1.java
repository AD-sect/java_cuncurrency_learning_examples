package ru.dmitruk.threadTasks.task1.join;

public class Task1 {

    public static void countWordsNumbers(String[] filePaths) {
        int totalWordsNumber = 0;

        for (String filaPath : filePaths) {
            ThreadWordsCounter threadWordsCounter = createThread(filaPath);
            totalWordsNumber += threadWordsCounter.getWordsNumber();
        }

        System.out.println("Number of total number of words present in given file: " + totalWordsNumber);
    }

    private static ThreadWordsCounter createThread(String filePath) {
        try {
            ThreadWordsCounter threadWordsCounter = new ThreadWordsCounter(filePath);
            Thread thread = new Thread(threadWordsCounter);
            thread.start();
            thread.join();
            return threadWordsCounter;
        } catch (InterruptedException e) {
           System.err.println(e.getMessage());
        }
        return null;
    }
}
