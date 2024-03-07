package edu.lazyprogrammer.executorframework;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Task implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("Start Task Executing Thread: "
                    + Thread.currentThread().getName());
            Thread.sleep(1000L); //Mimic Processing Time
            System.out.println("End Task Executing Thread: "
                    + Thread.currentThread().getName());
        } catch (InterruptedException ex) {
            Logger.getLogger(Task.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

}
