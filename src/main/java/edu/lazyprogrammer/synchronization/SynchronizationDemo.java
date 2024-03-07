package edu.lazyprogrammer.synchronization;

public class SynchronizationDemo{
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();
        CounterUpdater t1=new CounterUpdater(counter);
        CounterUpdater t2=new CounterUpdater(counter);
        //Starting Threads
        t1.start();
        t2.start();
        //Waiting for both the threads to complete
        t1.join();
        t2.join();
        System.out.println("Final Count: "+counter.getCount());
    }
}

class Counter{
    private int counter;
    public void increment(){
        synchronized (this) {
            counter++;
        }  
    }
    public int getCount(){
        return counter;
    }
}

class CounterUpdater extends Thread{
    private Counter counter;
    public CounterUpdater(Counter counter){
        this.counter=counter;
    }  
    @Override
    public void run(){
        for(int i=0;i<1000;i++){
            counter.increment();
        }
    }
}
