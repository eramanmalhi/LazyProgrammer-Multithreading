package edu.lazyprogrammer.producerconsumer;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Buffer {
    private final LinkedList<Integer> buffer=new LinkedList<>();
    private final int BUFFER_SIZE;
    
    public Buffer(int bufferSize){
        this.BUFFER_SIZE=bufferSize;
    }
    
    public void produce(int item) throws InterruptedException{
        synchronized (this) {
            while(BUFFER_SIZE==buffer.size()){
                wait();
            }
            buffer.add(item);
            System.out.println("Produced: "+item+":"+buffer);
            notify();
        }
    }
    public int consume() throws InterruptedException{
        int item;
        synchronized (this) {
            while(buffer.isEmpty()){
                wait();
            }
            item=buffer.removeFirst();
            System.out.println("Consumed: "+item+":"+buffer);
            notify();
        }
        return item;
    }
    public void sleepThread(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producer.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
