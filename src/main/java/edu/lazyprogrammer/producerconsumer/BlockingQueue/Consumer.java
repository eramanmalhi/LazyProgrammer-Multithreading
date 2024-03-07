package edu.lazyprogrammer.producerconsumer.BlockingQueue;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread{
    private final BlockingQueueBuffer buffer;
    public Consumer(BlockingQueueBuffer buffer){
        this.buffer=buffer;
    }
    public void run(){
            while(true){
                try {
                    int item=buffer.consume();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
}
