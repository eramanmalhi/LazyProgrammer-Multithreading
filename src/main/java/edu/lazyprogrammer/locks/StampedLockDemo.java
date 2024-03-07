package edu.lazyprogrammer.locks;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    private static final StampedLock resource = new StampedLock();
    public static void main(String[] args) {
        // Optimistic read
        long stamp = resource.tryOptimisticRead();
        System.out.println("Optimistic read from the shared resource");
        // Performing some optimistic read operations
        // Validate the optimistic read
        if (resource.validate(stamp)) {
            // Optimistic read is still valid
            System.out.println("Optimistic read is still valid");
        } else {
            // Optimistic read is not valid, upgrade to a read lock
            long readStamp = resource.readLock();
            try {
                System.out.println("Upgraded to a read lock");
                // Perform read operations
            } finally {
                resource.unlockRead(readStamp);
            }
        }
        // Exclusive write
        long writeStamp = resource.writeLock();
        try {
            System.out.println("Exclusive write to the shared resource");
            // Performing some write operations
        } finally {
            resource.unlockWrite(writeStamp);
        }
    }
}