package edu.lazyprogrammer.producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread{
    private final Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    public void run(){
        while(true){
            try {
                int item=(int) (Math.random()*100);
                buffer.produce(item);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
