package edu.lazyprogrammer.executorframework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Callable<String> callable = () -> {
            // Processing
            Thread.sleep(1000);
            return "Result returned from: " + Thread.currentThread().getName();
        };

        System.out.println("Submitting Callable");
        Future<String> future = executor.submit(callable);

        // Do some other processing
        System.out.println("Processing something else while callable is getting executed in parallel");

        // Blocking the Execution until the result is available
        System.out.println("Accessing Future Object to get Result");
        String result = future.get();
        System.out.println("Returned Result from Callable: " + result);

        //Shutting down executor
        executor.shutdown();
    }
}
