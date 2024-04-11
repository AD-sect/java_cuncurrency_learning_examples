package ru.dmitruk.threadTasks.task3.pingpong.withblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Task3WithBlockingQueue {

    public static int MAX_KICK_COUNT = 6;
    private final String PING_KICK = "PING";
    private final String PONG_KICK = "PONG";

    public static volatile boolean stopFlag = true;

    public static BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1, true);

    public void playGame() {
        Thread pingThread = new Thread(new KickIntoQueueThread(PING_KICK));
        Thread pongThread = new Thread(new KickIntoQueueThread(PONG_KICK));
        Thread printThread = new Thread(new PrintKickThread());

        pingThread.start();
        pongThread.start();
        printThread.start();
    }
}
