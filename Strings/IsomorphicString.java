

import java.util.HashMap;
import java.util.Map;

/**
 * @Problem Given two strings s1 and s2 consisting of only lowercase English
 *          letters and of equal length, check if these two strings are
 *          isomorphic to each other.
 *          If the characters in s1 can be changed to get s2, then two strings,
 *          s1 and s2 are isomorphic. A character must be completely swapped out
 *          for another character while maintaining the order of the characters.
 *          A character may map to itself, but no two characters may map to the
 *          same character.
 * 
 * @Example Input: s1 = "aab", s2 = "xxy"
 *          Output: true
 *          Explanation: Each character in s1 can be consistently mapped to a
 *          unique character in s2 (a → x, b → y).
 * 
 *          Input: s1 = "aab", s2 = "xyz"
 *          Output: false
 *          Explanation: Same character 'a' in s1 maps to two different
 *          characters 'x' and 'y' in s2.
 * 
 *          Input: s1 = "abc", s2 = "xxz"
 *          Output: false
 *          Explanation: Two different characters 'a' and 'b' in s1 maps with
 *          same character 'x' in s2.
 */
public class IsomorphicString {
    public static void main(String[] args) {
        System.out.println(areIsomorphic(null, null));
    }

    public static boolean areIsomorphic(String s1, String s2) {
        Map<Character, Integer> freqS1 = new HashMap<>();
        Map<Character, Integer> freqS2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (!freqS1.containsKey(s1.charAt(i))) {
                freqS1.put(s1.charAt(i), i);
            }
            if (!freqS2.containsKey(s2.charAt(i))) {
                freqS2.put(s2.charAt(i), i);
            }
            if (!freqS1.get(s1.charAt(i)).equals(freqS2.get(s2.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
