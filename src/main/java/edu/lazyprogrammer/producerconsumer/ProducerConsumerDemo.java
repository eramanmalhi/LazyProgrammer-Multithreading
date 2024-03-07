package edu.lazyprogrammer.producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        StoreBuffer store=new StoreBuffer();
        Thread producer=new Thread(()->{
            try {
                store.produce();
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumerDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        },"Producer");
        
        Thread consumer=new Thread(()->{
            try {
                store.consume();
            } catch (InterruptedException ex) {
                Logger.getLogger(ProducerConsumerDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        },"Consumer");
        producer.start();
        consumer.start();
    }
}
