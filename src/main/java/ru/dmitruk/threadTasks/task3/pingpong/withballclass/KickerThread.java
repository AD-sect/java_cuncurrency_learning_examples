package ru.dmitruk.threadTasks.task3.pingpong.withballclass;

public class KickerThread implements Runnable {

    private final String kickName;

    KickerThread(String kickName) {
        this.kickName = kickName;
    }

    @Override
    public void run() {
        Ball ball = Ball.getBall();
        while (ball.isGameAlive()) {
            if (ball.checkKickName(kickName)) {
                ball.kick(kickName);
            }
        }
    }
}
