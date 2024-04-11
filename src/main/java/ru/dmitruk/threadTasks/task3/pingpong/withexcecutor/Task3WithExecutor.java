package ru.dmitruk.threadTasks.task3.pingpong.withexcecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Task3WithExecutor {

    public static AtomicInteger count = new AtomicInteger(0);
    public static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public void playGame() {
        scheduledExecutorService.scheduleAtFixedRate(new KickBallThread("PING"), 1, 1, TimeUnit.MILLISECONDS);
        scheduledExecutorService.scheduleAtFixedRate(new KickBallThread("PONG"), 1, 1, TimeUnit.MILLISECONDS);
    }

}
