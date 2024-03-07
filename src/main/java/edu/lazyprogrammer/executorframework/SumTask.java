package edu.lazyprogrammer.executorframework;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 1000;
    private int[] array;
    private int start;
    private int end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // Student writes a small part of the essay
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Student decides their part is too big; let's divide it
            int mid = (start + end) >>> 1;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            // Fork: Students start writing their parts
            leftTask.fork();
            rightTask.fork();

            // Join: Combine the parts when everyone finishes
            return leftTask.join() + rightTask.join();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10000]; // Your essay (array) initialization here

        // The classroom (ForkJoinPool) is ready
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // The teacher (main task) assigns the big essay
        SumTask task = new SumTask(array, 0, array.length);

        // The classroom starts working on the essay
        long result = forkJoinPool.invoke(task);

        // The teacher announces the result
        System.out.println("Sum of the essay: " + result);
    }
}