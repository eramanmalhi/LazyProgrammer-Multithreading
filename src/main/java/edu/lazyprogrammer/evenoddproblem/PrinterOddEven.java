package edu.lazyprogrammer.evenoddproblem;

public class PrinterOddEven implements Runnable{
    private int num;
    private int max;
    Object lock;
    public PrinterOddEven(int num, int max){
        this.num=num;
        this.max=max;
        lock=new Object();
    }

    @Override
    public void run() {
        while(num<max){
            if(num%2==0 && "even".equals(Thread.currentThread()
            .getName())){
                synchronized (lock) {
                    try{
                    System.out.println("Even: "+num++);
                    lock.wait();
                    }catch(InterruptedException ex){
                        //Handle Exception
                    }
                }
            }
            if(num%2!=0 && "odd".equals(Thread.currentThread()
            .getName())){
                synchronized (lock) {
                    System.out.println("Odd: "+num++);
                    lock.notify();
                }
            }
        }
    }
    
    public static void main(String[] args) {
        PrinterOddEven printer=new PrinterOddEven(1, 100);
        Thread t1=new Thread(printer, "even");
        Thread t2=new Thread(printer, "odd");
        t1.start();
        t2.start();
    }
}
