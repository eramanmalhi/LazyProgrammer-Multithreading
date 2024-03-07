package edu.lazyprogrammer.evenoddproblem;

public class Demo {
    public static void main(String[] args) {
        Printer p1=new Printer(1, 10, 1);
        Printer p2=new Printer(1, 10, 0);
        
        Thread t1=new Thread(p1, "T1");
        Thread t2=new Thread(p2, "T2");
        
        t1.start();
        t2.start();
    }
}
