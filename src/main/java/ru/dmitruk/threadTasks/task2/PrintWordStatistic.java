package ru.dmitruk.threadTasks.task2;

import java.util.Map;

public class PrintWordStatistic {

    private PrintWordStatistic() {
        throw new ExceptionInInitializerError();
    }

    public synchronized static void printThreadWordResult(Map<String, Integer> wordsAndRepeatedNumbers) {
        wordsAndRepeatedNumbers.forEach((word, number) ->
                System.out.println("    Word: " + word + " number: " + number)
        );
    }
}
