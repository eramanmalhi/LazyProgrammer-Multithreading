package edu.lazyprogrammer.volatilekeyword;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VolatileDemo {
    private static volatile boolean flag=false;
    public static void main(String[] args) {
        Thread writerThread=new Thread(()->{
            System.out.println(Thread.currentThread().getName()+
                    ": Processing.");
            sleep(1L);
            flag=true;
            System.out.println(Thread.currentThread().getName()+
                    ": Flag updated to True.");
        },"Writer");
        
        Thread readerThread=new Thread(()->{
            while(!flag){
                //Busy Spinning
            }
            System.out.println(Thread.currentThread().getName()+
                    ": Received Flag as True, Exiting.");
        },"Reader");
        
        writerThread.start();
        readerThread.start();
    }

    private static void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(VolatileDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
