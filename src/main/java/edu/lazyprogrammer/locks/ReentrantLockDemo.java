package edu.lazyprogrammer.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static final ReentrantLock resource=new ReentrantLock();
    public static void main(String[] args) {
        //Acquiring Lock
        resource.lock();
        try{
            System.out.println("Inside Outer Critical Section");
            //Perform some operations
            
            //Reentrant Behavior
            //Start of Nested Critical Section
            resource.lock();
            try{
                System.out.println("Inside Nested Critical Section");
                //Perform some operations
            } finally{
                resource.unlock();
            }
            
        } finally{
            resource.unlock();
        }
    }
}
