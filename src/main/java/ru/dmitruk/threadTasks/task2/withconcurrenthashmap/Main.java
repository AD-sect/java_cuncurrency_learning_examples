package ru.dmitruk.threadTasks.task2.withconcurrenthashmap;


public class Main {

    public static void main(String[] args) {
        System.out.println("________________________TASK_2_CUNCURR_MAP____________________________");
        Task2Parallel task2Parallel = new Task2Parallel(args.length);
        task2Parallel.countWordsNumbers(args);
    }
}
