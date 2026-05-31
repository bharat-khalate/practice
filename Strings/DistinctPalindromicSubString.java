 

import java.util.ArrayList;
import java.util.HashSet;



/**
 * @Problem Given a string s of lowercase English letters. The task is to find
 *          all the distinct continuous palindromic sub-strings which are
 *          present in the string s.
 * 
 *          Note: You can return the Palindromic sub-strings in any order but
 *          the driver code will print the result in sorted order.
 * 
 * @Example Input: s = "abaaa"
 *          Output: ["a", "aa", "aaa", "aba", "b"]
 *          Explanation: All 5 distinct continuous palindromic sub-strings are
 *          listed above.
 * 
 *          Input: s = "geek"
 *          Output: ["e", "ee", "g", "k"]
 *          Explanation: All 4 distinct continuous palindromic sub-strings are
 *          listed above.
 */
public class DistinctPalindromicSubString {
    public static void main(String[] args) {
        System.out.println(palindromicSubstrDPBottomUp("abaaa"));
        System.out.println(palindromicSubstrCenterExpansion("abaaa"));
    }

    /**
     * DP Approach (Bottom UP/ Tabulation)
     * Time complexity: O(n^2)
     * Space Complexity: O(n^2)
     */
    public static ArrayList<String> palindromicSubstrDPBottomUp(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                if (s.charAt(i) == s.charAt(len + i - 1) && dp[i + 1][i + len - 2]) {
                    dp[i][len + i - 1] = true;
                }
            }
        }

        int kmp[] = new int[n];
        for (int i = 0; i < n; i++) {
            int j = 0, k = 1;
            while (k + i < n) {
                if (s.charAt(j + i) == s.charAt(k + i)) {
                    dp[k + i - j][k + i] = false;
                    kmp[k++] = ++j;
                } else {
                    if (j > 0) {
                        j = kmp[j - 1];
                    } else {
                        kmp[k++] = 0;
                    }
                }
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (dp[i][j])
                    list.add(s.substring(i, j + 1));
            }
        }
        return list;

    }

    /**
     * Center Expansion approach
     * Time complexity =O(n^2)
     * Space complexity= O(n^2)
     */
    public static ArrayList<String> palindromicSubstrCenterExpansion(String s) {
        int n = s.length();
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            computePalindromes(s, i, i, hs);
            computePalindromes(s, i, i + 1, hs);
        }
        return new ArrayList<>(hs);
    }

    public static void computePalindromes(String s, int start, int end, HashSet<String> hs) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            hs.add(s.substring(start, end + 1));
            start--;
            end++;
        }
    }

}
