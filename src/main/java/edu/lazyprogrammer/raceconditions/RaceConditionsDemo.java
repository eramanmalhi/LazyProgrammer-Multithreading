package edu.lazyprogrammer.raceconditions;

public class RaceConditionsDemo {
    //Shared Resource
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        //Runnable Task
        Runnable incrementCount = () -> {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        };
        //Creating two Threads to increment count by 10000 each
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
