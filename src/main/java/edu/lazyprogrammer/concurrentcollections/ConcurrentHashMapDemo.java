package edu.lazyprogrammer.concurrentcollections;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        // Creating a ConcurrentHashMap
        ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        // Adding elements to the ConcurrentHashMap
        concurrentMap.put("A", 1);
        concurrentMap.put("B", 2);
        concurrentMap.put("C", 3);

        // Displaying the initial map
        System.out.println("Initial ConcurrentHashMap: " + concurrentMap);

        // Updating an element
        concurrentMap.put("B", concurrentMap.get("B") + 10);

        // Displaying the updated map
        System.out.println("ConcurrentHashMap after update: " + concurrentMap);
    }
}
