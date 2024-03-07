package edu.lazyprogrammer.executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Runnable task = () -> {
            System.out.println("Starting HTTP Request: " + Thread.currentThread().getName());
            processing();
            System.out.println("Ending HTTP Request: " + Thread.currentThread().getName());

        };

        for (int i = 0; i < 10; i++) {
            executor.execute(task);
        }
        executor.shutdown();
    }

    private static void processing() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
