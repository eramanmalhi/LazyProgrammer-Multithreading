package edu.lazyprogrammer.executorframework;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

    public static void main(String[] args) {
        ScheduledExecutorService executor
                = Executors.newScheduledThreadPool(1);
        // Schedule a task to run every 3 seconds
        executor.scheduleWithFixedDelay(() -> {
            System.out.println("Task executed at: " + LocalTime.now());
            processing();
        }, 0, 2, TimeUnit.SECONDS);

        // Sleep for 10 seconds
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Shutdown the executor
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
