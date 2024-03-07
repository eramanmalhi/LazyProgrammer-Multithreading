package edu.lazyprogrammer.executorframework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CancelFutureTaskDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Callable<String> callable = () -> {
            // Processing
            Thread.sleep(5000);
            return "Result returned from: " + Thread.currentThread().getName();
        };

        System.out.println("Submitting Callable");
        Future<String> future = executor.submit(callable);
        int statusCheckCount = 0;
        while (!future.isDone()) {
            statusCheckCount++;
            System.out.println("Task In Progress...");
            Thread.sleep(200);
            if (statusCheckCount > 5) {
                future.cancel(true);
            }
        }
        if (!future.isCancelled()) {
            System.out.println("Task completed! Accessing Future Object to get Result");
            String result = future.get();
            System.out.println("Returned Result from Callable: " + result);
        } else {
            System.out.println("Task was cancelled");
        }

        //Shutting down executor
        executor.shutdown();
    }
}
