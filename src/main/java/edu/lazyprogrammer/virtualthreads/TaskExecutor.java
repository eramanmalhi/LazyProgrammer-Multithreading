package edu.lazyprogrammer.virtualthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author Amandeep Singh
 */
public class TaskExecutor {

    private final static int TASK_SIZE = 100;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        classicThreads();
        virtualThreads();
    }

    private static void classicThreads() throws InterruptedException, ExecutionException {
        try (ExecutorService executorService = Executors.newFixedThreadPool(10);) {

            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < TASK_SIZE; i++) {
                tasks.add(new Task(i));
            }
            Long time = System.currentTimeMillis();
            List<Future<Integer>> futures = executorService.invokeAll(tasks);
            Integer sum = 0;
            for (Future<Integer> future : futures) {
                sum += future.get();
            }
            time = System.currentTimeMillis() - time;
            System.out.println("Tasks Submitted: " + TASK_SIZE + ", Tasks Successfully Completed: " + sum + " in " + time + " ms");
        } catch (InterruptedException | ExecutionException iex) {
            System.err.println(iex.getMessage());
        }
    }

    private static void virtualThreads() {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();) {
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < TASK_SIZE; i++) {
                tasks.add(new Task(i));
            }
            Long time = System.currentTimeMillis();
            List<Future<Integer>> futures = executorService.invokeAll(tasks);
            Integer sum = 0;
            for (Future<Integer> future : futures) {
                sum += future.get();
            }
            time = System.currentTimeMillis() - time;
            System.out.println("Tasks Submitted: " + TASK_SIZE + ", Tasks Successfully Completed: " + sum + " in " + time + " ms");
        } catch (InterruptedException | ExecutionException iex) {
            System.err.println(iex.getMessage());
        }
    }
}
