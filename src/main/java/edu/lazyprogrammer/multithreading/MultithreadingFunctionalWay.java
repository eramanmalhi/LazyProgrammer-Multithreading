package edu.lazyprogrammer.multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;


public class MultithreadingFunctionalWay {

    public static void main(String[] args) {
        System.out.println("Main Thread Starts");
        Runnable task=()->{
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MultithreadingFunctionalWay.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Executing Thread:"
                        +Thread.currentThread().getName());
            };
        for(int i=0;i<10;i++){
            Thread t=new Thread(task);
            t.start();
        }

        System.out.println("Main Thread Ends");
    }

}
