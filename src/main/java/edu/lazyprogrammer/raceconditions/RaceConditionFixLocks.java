package edu.lazyprogrammer.raceconditions;

import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionFixLocks {
    //Shared Resource
    private static int count=0;
    private static final ReentrantLock lock=new ReentrantLock();
        
    public static void main(String[] args) throws InterruptedException {
        //Runnable Task
        Runnable incrementCount=()->{
            for(int i=0;i<10000;i++){
                lock.lock();
                try{
                    count++;
                }finally{
                    lock.unlock();
                }
            }
        };
        //Creating two Threads to increment count by 1000 each
        Thread threadA=new Thread(incrementCount);
        Thread threadB=new Thread(incrementCount);
        //Start both the Threads
        threadA.start();
        threadB.start();
        //Waiting for Threads to Complete Execution
        threadA.join();
        threadB.join();
        //Printing Final Count Value
        System.out.println("Count: "+count);
    }
}
