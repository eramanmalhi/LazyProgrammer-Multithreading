package edu.lazyprogrammer.virtualthreads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amandeep Singh
 */
public class Client {
    private static final int TASK_SIZE=50;
    private static Map<String, String> taskTime;
    public static void main(String[] args) {
        try {
            taskTime=HashMap.newHashMap(2);
            processData("classic");
            processData("virtual");
            System.out.println(taskTime);
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void processData(String serviceType) throws InterruptedException, ExecutionException {
        ExecutorService executor=null;
        if("classic".equalsIgnoreCase(serviceType)){
        executor=Executors.newFixedThreadPool(10);
        } else if("virtual".equalsIgnoreCase(serviceType)){
            executor=Executors.newVirtualThreadPerTaskExecutor();
        } else{
        throw new RuntimeException("Thread Service Type is Invalid");
        }
        List<Worker> tasks=new ArrayList<>();
        for(int i=0;i<TASK_SIZE;i++){
        tasks.add(new Worker(i));
        }
        long time=System.currentTimeMillis();
        List<Future<Integer>> result = executor.invokeAll(tasks);
        int sum=0;
        for(Future<Integer> future: result){
        sum+=future.get();
        }
        time=System.currentTimeMillis()-time;
        taskTime.put(serviceType, time+"ms ("+sum+")");
        System.out.println("sum = " + sum + "; time = " + time + " ms");
        executor.shutdown();
    }
    
}
