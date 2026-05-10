package Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @Problem Given a string s consisting only lowercase alphabets and an integer
 *          k. Find the count of all substrings of length k which have exactly
 *          k-1 distinct characters.
 * @Example Input: s = "abcc", k = 2
 *          Output: 1
 *          Explaination: Possible substring of length k = 2 are,
 *          ab : 2 distinct characters
 *          bc : 2 distinct characters
 *          cc : 1 distinct characters
 *          Only one valid substring so, count is equal to 1.
 * 
 *          Input: "aabab", k = 3
 *          Output: 3
 *          Explaination: Possible substring of length k = 3 are,
 *          aab : 2 distinct charcters
 *          aba : 2 distinct characters
 *          bab : 2 distinct characters
 *          All these substring are valid so, the total count is equal to 3.
 */
public class SubStrWithlenKAndunique {
    public static void main(String[] args) {
        System.out.println(substrCount("abcc", 2));
    }

    public static int substrCount(String s, int k) {
        int count = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (end = 0; end < s.length(); end++) {
            char tempC = s.charAt(end);
            freq.put(tempC, freq.getOrDefault(tempC, 0) + 1);
            if (end - start + 1 > k) {
                char left = s.charAt(start);
                freq.put(left, freq.get(left) - 1);
                if (freq.get(left) == 0) {
                    freq.remove(left);
                }
                start++;
            }
            if (end - start + 1 == k && freq.size() == k - 1) {
                count++;
            }
        }
        return count;
    }
}