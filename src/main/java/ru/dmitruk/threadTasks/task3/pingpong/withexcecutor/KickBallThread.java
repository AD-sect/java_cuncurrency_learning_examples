package ru.dmitruk.threadTasks.task3.pingpong.withexcecutor;


import static ru.dmitruk.threadTasks.task3.pingpong.withexcecutor.Task3WithExecutor.count;
import static ru.dmitruk.threadTasks.task3.pingpong.withexcecutor.Task3WithExecutor.scheduledExecutorService;

public class KickBallThread implements Runnable {

    private final String kick;
    private final Integer KICK_COUNT = 6;

    public KickBallThread(String kick) {
        this.kick = kick;
    }

    @Override
    public void run() {
        count.getAndIncrement();
        System.out.println(kick);
        if(count.get() == KICK_COUNT) {
            scheduledExecutorService.shutdown();
        }
    }
}
