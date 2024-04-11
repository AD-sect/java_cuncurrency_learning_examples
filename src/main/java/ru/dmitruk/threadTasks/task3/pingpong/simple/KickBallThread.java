package ru.dmitruk.threadTasks.task3.pingpong.simple;

import static ru.dmitruk.threadTasks.task3.pingpong.simple.Task3.PING_KICK;
import static ru.dmitruk.threadTasks.task3.pingpong.simple.Task3.PONG_KICK;
import static ru.dmitruk.threadTasks.task3.pingpong.simple.Task3.maxKickCount;
import static ru.dmitruk.threadTasks.task3.pingpong.simple.Task3.monitor;

public class KickBallThread implements Runnable {

    private final String kick;

    public KickBallThread(String kick) {
        this.kick = kick;
    }

    @Override
    public void run() {
        try {
            while (maxKickCount > 0) {
                synchronized (monitor) {
                    if (PONG_KICK.equals(kick)) {
                        monitor.wait();
                    }

                    System.out.println(kick);
                    maxKickCount--;
                    monitor.notify();

                    if (PING_KICK.equals(kick)) {
                        monitor.wait();
                    }
                }

            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }


}
