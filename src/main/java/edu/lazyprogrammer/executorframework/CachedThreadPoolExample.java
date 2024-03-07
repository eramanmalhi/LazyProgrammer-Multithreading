package edu.lazyprogrammer.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Runnable task = () -> {
            System.out.println("Starting HTTP Request: " + Thread.currentThread().getName());
            processing();
            System.out.println("Ending HTTP Request: " + Thread.currentThread().getName());

        };

        for (int i = 0; i < 1000; i++) {
            executor.execute(task);
        }
        executor.shutdown();
    }

    private static void processing() {
        try {
            Thread.sleep(200L);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
