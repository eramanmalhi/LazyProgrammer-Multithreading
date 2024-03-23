package edu.lazyprogrammer.raceconditions;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionFixAtomicOperations {
    //Shared Resource
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        //Runnable Task
        Runnable incrementCount = () -> {
            for (int i = 0; i < 10000; i++) {
                count.incrementAndGet();
            }
        };
        //Creating two Threads to increment count by 1000 each
        Thread threadA = new Thread(incrementCount);
        Thread threadB = new Thread(incrementCount);
        //Start both the Threads
        threadA.start();
        threadB.start();
        //Waiting for Threads to Complete Execution
        threadA.join();
        threadB.join();
        //Printing Final Count Value
        System.out.println("Count: " + count);
    }
}
