/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package edu.lazyprogrammer.executorframework;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Amandeep Singh
 */
public class PackageManagerTest {
    PackageManager manager=new PackageManager();
    @Test
    public void testpackShirts1() {
        int[] result = manager.packShirts(100, 10);
        int[] expected = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testpackShirts2() {   
        int[] result = manager.packShirts(109, 10);
        int[] expected = {11, 11, 11, 11, 11, 11, 11, 11, 11, 10};
        assertArrayEquals(expected, result);
    }  
}
