package edu.lazyprogrammer.sleepdemo;

import java.time.LocalDateTime;

public class ThreadSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Thread Starts"+
                LocalDateTime.now());
        pauseExecution(5000L);
        System.out.println("Main Thread Resumes"+
                LocalDateTime.now());
    }

    private static void pauseExecution(long delay) throws InterruptedException {
        System.out.println("Pausing the Execution of: "+
                Thread.currentThread().getName());
        Thread.sleep(delay);
    }
}
