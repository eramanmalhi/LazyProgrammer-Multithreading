package edu.lazyprogrammer.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private final static int NO_OF_PARTIES=5;
    
    public static void main(String[] args) {
        CyclicBarrier meetingPoint=new CyclicBarrier(NO_OF_PARTIES);
        
        for(int i=1;i<=NO_OF_PARTIES;i++){
            Friend friend=new Friend(meetingPoint, "Friend-"+i);
            friend.start();
        }
    }
}
