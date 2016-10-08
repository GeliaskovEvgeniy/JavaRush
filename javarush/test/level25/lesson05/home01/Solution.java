package com.javarush.test.level25.lesson05.home01;

/* Мониторинг состояния нити
В отдельном классе создать нить LoggingStateThread,
которая будет выводить в консоль все состояния (State) переданной в конструктор нити.
Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
Метод main не участвует в тестировании.
*/
public class Solution
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread target = new Thread();
        LoggingStateThread loggingStateThread = new LoggingStateThread(target);

        loggingStateThread.start();
        target.start();  //NEW
        Thread.sleep(500); //RUNNABLE
        target.join(500);
        Thread.sleep(400);
        target.interrupted(); //TERMINATED
        Thread.sleep(500);
    }

    private static class LoggingStateThread extends Thread
    {
        private Thread thread;

        public LoggingStateThread(Thread thread)
        {
            System.out.println(thread.getState());
            this.thread = thread;
            setDaemon(true);
        }

        @Override
        public void run()
        {
            System.out.println(thread.getState());
            System.out.println(thread.getState());



        }
    }
}
