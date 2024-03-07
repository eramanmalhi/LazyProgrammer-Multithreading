package edu.lazyprogrammer.atomicoperations;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter=new AtomicCounter();
        Thread t1=new Thread(()->{
            for(int i=0;i<1000;i++){
                counter.increment();
            }
        },"Thread-1");
        
        Thread t2=new Thread(()->{
            for(int i=0;i<1000;i++){
                counter.increment();
            }
        },"Thread-2");
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Counter: "+counter.getCount());
    }
}
