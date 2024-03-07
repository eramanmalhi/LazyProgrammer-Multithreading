package edu.lazyprogrammer.sleepdemo;


public class YieldDemo {
    public static void main(String[] args) {
        Thread t1=new Thread(
        ()->{
            for(int i=0;i<5;i++){
                System.out.println("Thread-1 Executing: "+i);
                Thread.yield();
            }
        }
        );
        
        Thread t2=new Thread(
        ()->{
            for(int i=0;i<5;i++){
                System.out.println("Thread-2 Executing: "+i);
                Thread.yield();
            }
        }
        );
        
        t1.start();
        t2.start();
    }
}