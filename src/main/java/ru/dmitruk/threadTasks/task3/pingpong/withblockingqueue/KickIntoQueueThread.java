package ru.dmitruk.threadTasks.task3.pingpong.withblockingqueue;

import static ru.dmitruk.threadTasks.task3.pingpong.withblockingqueue.Task3WithBlockingQueue.blockingQueue;
import static ru.dmitruk.threadTasks.task3.pingpong.withblockingqueue.Task3WithBlockingQueue.stopFlag;

public class KickIntoQueueThread implements Runnable {

    private final String kick;

    public KickIntoQueueThread(String kick) {
        this.kick = kick;
    }

    @Override
    public void run() {
        while (stopFlag) {
            try {
                blockingQueue.put(kick);
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
