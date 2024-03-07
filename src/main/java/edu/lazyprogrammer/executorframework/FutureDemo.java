
package edu.lazyprogrammer.executorframework;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FutureDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor=Executors.newSingleThreadExecutor();
        CalculateSquare calculate=new CalculateSquare(5);
        Future<String> result= executor.submit(calculate);
        executor.shutdown();
        System.out.println("Waiting");
        System.out.println(result.get());
        System.out.println("Bye");
    }
}

class CalculateSquare implements Callable<String>{
    private int inputNumber;
    public CalculateSquare(int input){
        inputNumber=input;
    }

    @Override
    public String call() throws Exception {
        process();
        return "Square of "+inputNumber+" is "+inputNumber*inputNumber;
    }

    private void process() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException ex) {
            Logger.getLogger(CalculateSquare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
