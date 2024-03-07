package edu.lazyprogrammer.virtualthreads;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amandeep Singh
 */
public class Worker implements Callable<Integer>{
    
    private final int number;

    public Worker(int number) {
        this.number = number;
    }
    
    @Override
    public Integer call() {
        System.out.println("Started Processing: "+Thread.currentThread().getName()+" : "+number);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, "Cancelled Processing: "+Thread.currentThread().getName()+" : "+number, ex);
            return -1;
        }
        System.out.println("Finished Processing: "+Thread.currentThread().getName()+" : "+number);
        return 1;
    }  
}
