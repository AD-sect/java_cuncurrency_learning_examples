package ru.dmitruk.threadTasks.task3.pingpong.simple;

import ru.dmitruk.threadTasks.task3.pingpong.withballclass.Ball;

public class Task3 {



    public static final Object monitor = new Object();
    public static int maxKickCount = 6;

    public static final String PING_KICK = "PING";
    public static String PONG_KICK = "PONG";

    public void playGame() {
        Thread pingThread = new Thread(new KickBallThread(PING_KICK));
        Thread pongThread = new Thread(new KickBallThread(PONG_KICK));

        Ball ball = Ball.getBall();

        pongThread.start();
        pingThread.start();

    }
}
