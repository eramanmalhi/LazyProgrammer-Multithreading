package edu.lazyprogrammer.virtualthreads;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amandeep Singh
 */
public class Task implements Callable<Integer> {

    private int num;

    public Task(int num) {
        this.num = num;
    }

    @Override
    public Integer call() {
        //System.out.println("Task Execution Started:"+Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("Task Execution Cancelled:"+Thread.currentThread());
        }
        //System.out.println("Task Execution Completed:"+Thread.currentThread());
        return 1;
    }

}
