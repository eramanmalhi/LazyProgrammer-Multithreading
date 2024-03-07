package edu.lazyprogrammer.volatilekeyword;

public class VisibilityExample {
    private static boolean flag = false;

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true; // Set the flag to true
            System.out.println("Flag is set to true.");
        });

        Thread readerThread = new Thread(() -> {
            while (!flag) {
                // Keep spinning until flag becomes true
            }
            System.out.println("Flag is true. Exiting.");
        });

        writerThread.start();
        readerThread.start();
    }
}

