package edu.lazyprogrammer.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BasicLockUsage {
    private Lock resource=new ReentrantLock();
    
    public void updateResource(){
        resource.lock();
        try{
            //Critical Section: Shared Resource Update
        } finally{
            resource.unlock();
        }
    }
}
