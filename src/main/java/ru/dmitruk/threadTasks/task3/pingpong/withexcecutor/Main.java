package ru.dmitruk.threadTasks.task3.pingpong.withexcecutor;

public class Main {

    public static void main(String[] args) {
        System.out.println("________________________TASK_3_WITH_EXECUTOR________________________");
        Task3WithExecutor task3WithExecutor = new Task3WithExecutor();
        task3WithExecutor.playGame();
    }
}
