package edu.lazyprogrammer.sleepdemo;

import java.util.logging.Level;
import java.util.logging.Logger;


public class WaitNotifyDemo {

    public static void main(String[] args) {
        //Shared Resource
        Object resource=new Object();
        
        Thread t1=new Thread(
        ()->{
            synchronized (resource) {
                try {
                    System.out.println("Thread-1: is running");
                    System.out.println("Thread-1: is pausing using wait() call");
                    resource.wait();
                    System.out.println("Thread-1: Resuming after receiving notify() call");
                } catch (InterruptedException ex) {
                    Logger.getLogger(WaitNotifyDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        
        Thread t2=new Thread(
        ()->{
            synchronized (resource) {
                try {
                    System.out.println("Thread-2: is running");
                    Thread.sleep(3000L);
                    System.out.println("Thread-2: Notifying Thread-1 to wake-up");
                    resource.notify();
                } catch (InterruptedException ex) {
                    Logger.getLogger(WaitNotifyDemo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        t1.start();
        t2.start();
    }
}
