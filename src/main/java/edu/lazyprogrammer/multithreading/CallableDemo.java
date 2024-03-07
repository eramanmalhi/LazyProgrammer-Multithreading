package edu.lazyprogrammer.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;

public class CallableDemo implements Callable<Integer> {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Main Thread Starts");
        CallableDemo callable=new CallableDemo();
        ExecutorService executor=Executors.newFixedThreadPool(10);
        List<Future<Integer>> futures=new ArrayList<>();
        for(int i=0;i<10;i++){
            Future<Integer> submittedJob=executor.submit(callable);
            futures.add(submittedJob);
        }
        
        for(Future future: futures){
            System.out.println("Returned Value:"+future.get());
        }
        executor.shutdown();
        System.out.println("Main Thread Ends");
    }

    @Override
    public Integer call() throws Exception {
        //Sleep represent delay in processing
        Thread.sleep(2000);
        System.out.println("Executing Thread:"
                +Thread.currentThread().getName());
        return ThreadLocalRandom.current().nextInt(1, 100);
    }

}
