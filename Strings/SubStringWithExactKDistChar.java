 ;

import java.util.HashMap;
import java.util.Map;

/**
 * @Problem You are given a string s consisting of lowercase characters and an
 *          integer k, You have to count all possible substrings that have
 *          exactly k distinct characters.
 * 
 * @Example Input: s = "abc", k = 2
 *          Output: 2
 *          Explanation: Possible substrings are ["ab", "bc"]
 * 
 *          Input: s = "aba", k = 2
 *          Output: 3
 *          Explanation: Possible substrings are ["ab", "ba", "aba"]
 * 
 *          Input: s = "aa", k = 1
 *          Output: 3
 *          Explanation: Possible substrings are ["a", "a", "aa"]
 */
public class SubStringWithExactKDistChar {
    public static void main(String[] args) {
        System.out.println(countSubstr("abc", 2));
    }

    public static int countSubstr(String s, int k) {
        return countUptoKSubStrings(s, k) - countUptoKSubStrings(s, k - 1);
    }

    public static int countUptoKSubStrings(String s, int k) {
        int count = 0;
        Map<Character, Integer> register = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char tempC = s.charAt(end);
            register.put(tempC, register.getOrDefault(tempC, 0) + 1);
            while (register.size() > k) {
                tempC = s.charAt(start);
                register.put(tempC, register.get(tempC) - 1);
                if (register.get(tempC) == 0)
                    register.remove(tempC);
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }
}
