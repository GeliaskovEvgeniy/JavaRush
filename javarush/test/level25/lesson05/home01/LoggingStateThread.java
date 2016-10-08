package com.javarush.test.level25.lesson05.home01;

public class LoggingStateThread extends Thread
{
    private Thread target;

    private State state1;

    public LoggingStateThread(Thread target)
    {
        this.target = target;
        this.state1 = target.getState();
        setDaemon(true);
    }

    @Override
    public void run()
    {
        while (!target.isInterrupted()){
            Thread.State state = target.getState();

            if (state != state1)
                System.out.println(state);
            state1 = target.getState();
            if (state1 == State.TERMINATED)
                target.interrupt();
        }
    }
}
