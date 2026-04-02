
/**
 * Given: A non-empty array of integer numbers, every element appears twice
 * except for one.
 * Goal: Determine the element that appears only once.
 * (DO NOT use any inbuilt functionalities like Collections or related things
 * from any other languages)
 * Example 1:
 * • Input: [2,2,1]
 * • Output: 1
 * • Explanation: Each element appears twice except for 1.
 * 
 */

import java.util.*;

public class FindUniqueInTwice {
    public static void main(String args[]) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int arr[] = { 4,1,2,1,2};
        /**
         * Alternate Aproach
         * int res=0;
         * for(int val:arr)res=res^num;
         * System.out.println(res)
         */
        for (int val : arr)
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        freqMap.forEach((key,val)->{
            if(val==1){
                System.out.println(key);
                return;
            }
        });
    }
}
