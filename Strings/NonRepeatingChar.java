 ;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a string s consisting of lowercase English Letters. return the first
 * non-repeating character in s. If there is no non-repeating character, return
 * '$'.
 * 
 * @example
 *          Input: s = "geeksforgeeks"
 *          Output: 'f'
 *          Explanation: In the given string, 'f' is the first character in the
 *          string which does not repeat.
 * 
 *          Input: s = "racecar"
 *          Output: 'e'
 *          Explanation: In the given string, 'e' is the only character in the
 *          string which does not repeat.
 * 
 *          Input: s = "aabbccc"
 *          Output: '$'
 *          Explanation: All the characters in the given string are repeating.
 */

public class NonRepeatingChar {
    public static char nonRepeatingChar(String s) {
        // code here
        int[] visited = new int[26];
        Arrays.fill(visited, -1);
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (visited[idx] == -1) {
                visited[idx] = i;
            } else {
                visited[idx] = -2;
            }
        }
        int res = Arrays.stream(visited).boxed().filter(i -> i >= 0).min(Comparator.naturalOrder()).orElse(-1);
        return res != -1 ? s.charAt(res) : '$';
    }

    public static void main(String args[]) {
        String str = "bharat";
        System.out.println(nonRepeatingChar(str));
    }
}
