package edu.lazyprogrammer.evenoddproblem;

public class Printer implements Runnable{
    private static int number;
    private final int maxNumber;
    private final int remainder;
    static Object lock;
    public Printer(int number, int maxNumber, int remainder){
        this.number=number;
        this.maxNumber=maxNumber;
        this.remainder=remainder;
        lock=new Object();
    }

    @Override
    public void run() {
        while(number<maxNumber){
            synchronized (lock) {
                while(number%2!=remainder){
                    try{
                    lock.wait();
                    }catch(InterruptedException ex){
                        //Handle Exception
                    }
                }
                System.out.println(Thread.currentThread().getName()+
                        ":"+number++);
                lock.notify();
            }
        }
    }
}
