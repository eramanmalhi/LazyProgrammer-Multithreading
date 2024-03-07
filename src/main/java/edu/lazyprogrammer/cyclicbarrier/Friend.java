package edu.lazyprogrammer.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Friend extends Thread {

    private final CyclicBarrier barrier;
    private final String friendName;

    public Friend(CyclicBarrier barrier, String friendName) {
        this.barrier = barrier;
        this.friendName = friendName;
    }

    @Override
    public void run() {
        try {
            System.out.println(friendName + " is getting Ready!!!");
            getReadyAndBeAtMeetingPoint();
            System.out.println(friendName + " is ready and waiting for "
                    + (barrier.getParties() - barrier.getNumberWaiting() - 1)
                    + " Friends at the Meeting Point");
            barrier.await();
            System.out.println(friendName + " is now continueing with the Trip");
        } catch (InterruptedException | BrokenBarrierException ex) {
            Logger.getLogger(Friend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getReadyAndBeAtMeetingPoint() {
        try {
            Thread.sleep(ThreadLocalRandom.current()
                    .nextLong(5000, 15000));
        } catch (InterruptedException ex) {
            Logger.getLogger(Friend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
