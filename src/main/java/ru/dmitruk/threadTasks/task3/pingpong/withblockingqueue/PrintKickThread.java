package ru.dmitruk.threadTasks.task3.pingpong.withblockingqueue;

import static ru.dmitruk.threadTasks.task3.pingpong.withblockingqueue.Task3WithBlockingQueue.blockingQueue;
import static ru.dmitruk.threadTasks.task3.pingpong.withblockingqueue.Task3WithBlockingQueue.MAX_KICK_COUNT;
import static ru.dmitruk.threadTasks.task3.pingpong.withblockingqueue.Task3WithBlockingQueue.stopFlag;

public class PrintKickThread implements Runnable {


    @Override
    public void run() {
        try {
            for (int i = 0; i < MAX_KICK_COUNT; i++) {
                System.out.println(blockingQueue.take());
            }
            stopFlag = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
