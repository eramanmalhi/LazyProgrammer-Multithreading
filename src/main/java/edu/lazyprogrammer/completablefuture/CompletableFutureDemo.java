package edu.lazyprogrammer.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFutureDemo {

    private static final Runnable runnableTask = () -> {
        try {
            Thread.sleep(1000L);
            System.out.println("Execution done using: "
                    + Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    };

    private static final Supplier<String> supplierTask = () -> {
        try {
            Thread.sleep(1000L);
            System.out.println("Execution done using: "
                    + Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        return "Result from " + Thread.currentThread().getName();
    };

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //submitRunAsync(runnableTask);
        //submitSupplyAsync(supplierTask);
        //submitThenApply(supplierTask);
        //submitThenAccept(supplierTask);
        //submitThenRun(supplierTask);
    }

    private static void submitRunAsync(Runnable runnableTask) throws ExecutionException, InterruptedException {
        System.out.println("=========CompletableFuture.runAsync Demo=========");
        CompletableFuture<Void> runAsync
                = CompletableFuture.runAsync(runnableTask);
        runAsync.get();
        System.out.println();
    }

    private static void submitSupplyAsync(Supplier<String> supplierTask) throws InterruptedException, ExecutionException {
        System.out.println("=========CompletableFuture.supplyAsync Demo=========");
        CompletableFuture<String> supplyAsyncFuture
                = CompletableFuture.supplyAsync(supplierTask);
        System.out.println(supplyAsyncFuture.get());
        System.out.println();
    }

    private static void submitThenApply(Supplier<String> supplierTask) throws InterruptedException, ExecutionException {
        System.out.println("=========CompletableFuture.thenApply Demo=========");
        CompletableFuture<String> thenApplyFuture
                = CompletableFuture.supplyAsync(supplierTask)
                        .thenApply((message) -> {
                            return "Adding Hello from thenApply: " + message;
                        });
        System.out.println(thenApplyFuture.get());
        System.out.println();
    }

    private static void submitThenAccept(Supplier<String> supplierTask) throws InterruptedException, ExecutionException {
        System.out.println("=========CompletableFuture.thenAccept Demo=========");
        CompletableFuture<Void> thenAcceptFuture 
                = CompletableFuture.supplyAsync(supplierTask)
                .thenAccept(message -> {
                    System.out.println("Accepting Message: " + message);
                });
        thenAcceptFuture.get();
        System.out.println();
    }
    
    private static void submitThenRun(Supplier<String> supplierTask) throws InterruptedException, ExecutionException {
        System.out.println("=========CompletableFuture.thenRun Demo=========");
        CompletableFuture<Void> thenRunFuture 
                = CompletableFuture.supplyAsync(supplierTask)
                .thenRun(() -> {
                    System.out.println("Using thenRun to display Completed Message");
                });
        thenRunFuture.get();
        System.out.println();
    }
}
