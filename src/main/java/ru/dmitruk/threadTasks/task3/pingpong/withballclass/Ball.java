package ru.dmitruk.threadTasks.task3.pingpong.withballclass;

public class Ball {

    private static Ball instance = new Ball();
    private final int MAX_KICK_COUNT = 6;
    private int kicksCount = 0;
    private String kickName = "PONG";

    public static Ball getBall() {
        return instance;
    }

    public synchronized void kick(String kickName) {
        kicksCount++;
        this.kickName = kickName;
        System.out.println(kickName);
    }

    public boolean checkKickName(String kickName) {
        return !kickName.equals(this.kickName);
    }

    public boolean isGameAlive() {
        return kicksCount < MAX_KICK_COUNT;
    }

}
