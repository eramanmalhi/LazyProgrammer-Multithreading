package edu.lazyprogrammer.executorframework;

import java.util.Arrays;

/**
 *
 * @author Amandeep Singh
 */
public class PackageManager {
    
    public int[] packShirts(int shirtCount, int bagCount){
        int[] packedBags=new int[bagCount];
        int leastCommonShirtCountPerBag=shirtCount/bagCount;
        int remainingShirts=shirtCount%bagCount;
        Arrays.fill(packedBags, leastCommonShirtCountPerBag);
        
        for(int i=0;i<remainingShirts;i++){
            packedBags[i]++;
        }
        return packedBags;
    }
}
