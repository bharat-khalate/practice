 ;

import java.util.HashMap;
import java.util.Map;

/**
 * @Problem Given a string S which only contains lowercase alphabets. Find the
 *          length of the longest substring of S such that the characters in it
 *          can be rearranged to form a palindrome.
 * 
 * @Example Input:
 *          S = "aabe"
 *          Output:
 *          3
 *          Explanation:
 *          The substring "aab" can be rearranged to
 *          "aba" which is the longest palindrome
 *          possible for this String.
 * 
 *          Input:
 *          S = "adbabd"
 *          Output:
 *          6
 *          Explanation:
 *          The whole string “adbabd” can be
 *          rearranged to form a palindromic substring.
 *          One possible arrangement is "abddba".
 *          Thus, output length of the string is 6.
 * 
 */
public class LongestSubstringToFormPalindrome {
    public static void main(String args[]) {
        System.out.println(longestSubstring("adbabd"));
    }

    static int longestSubstring(String S) {
        int mask = 0;
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, -1);
        for (int i = 0; i < S.length(); i++) {
            int num = S.charAt(i) - 'a';
            mask ^= (1 << num);
            if (freq.containsKey(mask))
                ans = Math.max(ans, i - freq.get(mask));
            else
                freq.put(mask, i);

            for (int j = 0; j < 26; j++) {
                int mask2 = mask ^ (1 << j);
                if (freq.containsKey(mask2))
                    ans = Math.max(ans, i - freq.get(mask2));
            }
        }
        return ans;
    }

}
