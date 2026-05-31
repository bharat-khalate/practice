 

import java.util.HashMap;
import java.util.Map;

/**
 * @Problem Given two strings S1 and S2 . Return "1" if both strings are
 *          anagrams
 *          otherwise return "0" .
 * 
 *          Note: An anagram of a string is another string with exactly the same
 *          quantity
 *          of each character in it, in any order.
 * @Example Input: S1 = "cdbkdub" , S2 = "dsbkcsdn"
 *          Output: 0
 *          Explanation: Length of S1 is not same
 *          as length of S2.
 * @Example Input: S1 = "geeks" , S2 = "skgee"
 *          Output: 1
 *          Explanation: S1 has the same quantity
 *          of each character in it as S2.
 */
public class AnagramCheck {
    public static void main(String args[]) {
        System.out.println(areAnagram("cdbkdub", "dsbkcsdn"));
    }

    static int areAnagram(String s1, String s2) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            freqMap.put(s1.charAt(i), freqMap.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            freqMap.put(s2.charAt(i), freqMap.getOrDefault(s2.charAt(i), 0) - 1);
        }
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() != 0)
                return 0;
        }
        return 1;
    }
}
