package edu.lazyprogrammer.atomicoperations;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
       private AtomicInteger count = new AtomicInteger(0);

       public void increment() {
           count.incrementAndGet(); // Atomic increment operation
       }

       public int getCount() {
           return count.get(); // Atomic read operation
       }
   }
