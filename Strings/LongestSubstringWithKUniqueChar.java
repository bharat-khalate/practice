 ;

import java.util.HashMap;
import java.util.Map;

/**
 * @Problem You are given a string s consisting only lowercase alphabets and an
 *          integer k. Your task is to find the length of the longest substring
 *          that contains exactly k distinct characters.
 * 
 *          Note : If no such substring exists, return -1.
 * @Example Input: s = "aabacbebebe", k = 3
 *          Output: 7
 *          Explanation: The longest substring with exactly 3 distinct
 *          characters is "cbebebe", which includes 'c', 'b', and 'e'.
 * 
 *          Input: s = "aaaa", k = 2
 *          Output: -1
 *          Explanation: There's no substring with 2 distinct characters.
 * 
 *          Input: s = "aabaaab", k = 2
 *          Output: 7
 *          Explanation: The entire string "aabaaab" has exactly 2 unique
 *          characters 'a' and 'b', making it the longest valid substring.
 */

public class LongestSubstringWithKUniqueChar {

    public static void main(String[] args) {
        System.out.println(longestKSubstr("aabacbebebe", 3));
    }

    public static int longestKSubstr(String s, int k) {
        int count = -1;
        Map<Character, Integer> freqMap = new HashMap<>();
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            freqMap.put(s.charAt(end), freqMap.getOrDefault(s.charAt(end), 0) + 1);
            while (start <= end && freqMap.size() > k) {
                freqMap.put(s.charAt(start), freqMap.get(s.charAt(start)) - 1);
                if (freqMap.get(s.charAt(start)) <= 0)
                    freqMap.remove(s.charAt(start));
                start++;
            }
            if (freqMap.size() == k)
                count = Math.max(count, end - start + 1);
            end++;
        }
        return count;
    }

}