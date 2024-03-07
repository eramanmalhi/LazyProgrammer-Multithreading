package edu.lazyprogrammer.producerconsumer;

public class Demo {
    public static void main(String[] args) {
        Buffer buffer=new Buffer(3);
        for(int i=0;i<5;i++){
            Producer producer=new Producer(buffer);
            producer.start();
        }

        Consumer consumer=new Consumer(buffer);
        consumer.start();
    }
}
