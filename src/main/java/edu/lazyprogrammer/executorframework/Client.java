package edu.lazyprogrammer.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Start: "+Thread.currentThread().getName());
        ExecutorService executor=Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
        executor.execute(new Task());
        }
        executor.shutdown();
        System.out.println("Main Continue: "+Thread.currentThread().getName());
        Thread.sleep(500L);
        System.out.println("Main End: "+Thread.currentThread().getName());
    }
}
