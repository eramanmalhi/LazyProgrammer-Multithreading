package edu.lazyprogrammer.producerconsumer;

import java.util.LinkedList;

public class StoreBuffer {
    private LinkedList<Integer> store=new LinkedList<>();
    private final int size=5;
    public void produce() throws InterruptedException{
        int value=0;
        while(true){
            synchronized (this) {
                while(store.size()==size){
                    wait();
                }
                System.out.println("Produced: "+value);
                store.add(value++);
                System.out.println("Store Values: "+store.size());
                notify();
                Thread.sleep(1000);
            }
        }
    }
    
    public void consume() throws InterruptedException{
        while(true){
            synchronized (this) {
                while(store.size()==0){
                    wait();
                }
                int value=store.removeFirst();
                System.out.println("Comsumed: "+value);
                System.out.println("Store Values: "+store.size());
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
