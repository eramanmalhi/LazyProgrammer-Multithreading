package edu.lazyprogrammer.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        
        CountDownLatch latch=new CountDownLatch(5);
        
        System.out.println(Thread.currentThread().getName()+": Let's Go For Hiking!!!");
        for(int i=1;i<=5;i++){
            Thread thread=new Thread(()->{
                System.out.println(Thread.currentThread().getName()+": Getting Ready");
                sleep(ThreadLocalRandom.current().nextInt(400, 700));
                System.out.println(Thread.currentThread().getName()+": Ready");
                latch.countDown();
            }, "Friend-"+i);
            thread.start();
            
        }
        latch.await();
        System.out.println(Thread.currentThread().getName()+": Start Hiking!!!");
    }

    private static void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(CountDownLatchDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
