package edu.lazyprogrammer.producerconsumer.BlockingQueue;

public class Demo {
    public static void main(String[] args) {
        BlockingQueueBuffer buffer=new BlockingQueueBuffer(3);
        for(int i=0;i<5;i++){
            Producer producer=new Producer(buffer);
            producer.start();
        }
        Consumer consumer=new Consumer(buffer);
        consumer.start();
    }
}
