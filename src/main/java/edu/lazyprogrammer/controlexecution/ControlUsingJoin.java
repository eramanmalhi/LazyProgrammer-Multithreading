package edu.lazyprogrammer.controlexecution;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlUsingJoin {

    public static void main(String[] args) {
        Thread t1 = new Thread(
                () -> {
                    System.out.println("T1: Setup Started");
                    for (int i = 0; i < 10; i++) {
                        sleep(ThreadLocalRandom.current().nextInt(400, 600));
                        System.out.println("T1: Setup Progress: " + (i + 1) * 10 + "%");
                    }
                    System.out.println("T1: Setup Completed");
                }
        );

        Thread t2 = new Thread(
                () -> {
                    try {
                        t1.join();
                        System.out.println("T2: Processing Started");
                        for (int i = 0; i < 10; i++) {
                            sleep(500L);
                            System.out.println("T2: Processing Progress: " + (i + 1) * 10 + "%");
                        }
                        System.out.println("T2: Processing Completed");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ControlUsingJoin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        );

        Thread t3 = new Thread(
                () -> {
                    try {
                        t1.join();
                        System.out.println("T3: Processing Started");
                        for (int i = 0; i < 10; i++) {
                            sleep(700L);
                            System.out.println("T3: Processing Progress: " + (i + 1) * 10 + "%");
                        }
                        System.out.println("T3: Processing Completed");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ControlUsingJoin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
        );
        t1.start();
        t2.start();
        t3.start();

    }

    private static void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlUsingJoin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
