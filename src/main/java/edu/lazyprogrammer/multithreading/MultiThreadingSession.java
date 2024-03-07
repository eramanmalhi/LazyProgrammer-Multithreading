package edu.lazyprogrammer.multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MultiThreadingSession {

    public static void main(String[] args) {
        System.out.println("Main Thread Starts");
        for (int i = 0; i < 10; i++) {
            //Thread t1=new ThreadImpl();
            Thread t1 = new Thread(new RunnableImpl(), "MyThread-" + i);
            t1.start();
        }
        System.out.println("Main Thread Ends");
    }

}

class ThreadImpl extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        System.out.println("Executing Thread: " + Thread.currentThread()
                .getName());
    }
}

class RunnableImpl implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(RunnableImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        System.out.println("Executing Thread: " + Thread.currentThread()
                .getName());

    }

}
