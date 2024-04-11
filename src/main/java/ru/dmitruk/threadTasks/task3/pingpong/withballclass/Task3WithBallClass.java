package ru.dmitruk.threadTasks.task3.pingpong.withballclass;


public class Task3WithBallClass {

    private final String PING_KICK = "PING";
    private final String PONG_KICK = "PONG";

    public void playGame() {
        Thread pingThread = new Thread(new KickerThread(PING_KICK));
        Thread pongThread = new Thread(new KickerThread(PONG_KICK));

        pingThread.start();
        pongThread.start();
    }

}
