 ;

import java.util.Arrays;

/**
 * @Problem Given a string s, return the length of the longest palindromic
 *          subsequence.
 *          A subsequence is a sequence that can be derived from the given
 *          sequence by deleting some or no elements without changing the order
 *          of the remaining elements.
 *          A palindromic sequence is a sequence that reads the same forward and
 *          backward.
 * 
 * @Example Input: s = "bbabcbcab"
 *          Output: 7
 *          Explanation: Subsequence "babcbab" is the longest subsequence which
 *          is also a palindrome.
 * 
 *          Input: s = "abcd"
 *          Output: 1
 *          Explanation: "a", "b", "c" and "d" are palindromic and all have a
 *          length 1.
 * 
 *          Input: s = "agbdba"
 *          Output: 5
 *          Explanation: The longest palindromic subsequence is "abdba", which
 *          has a length of 5. The characters in this subsequence are taken from
 *          the original string "agbdba", and they maintain the order of the
 *          string while forming a palindrome.
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(longestPalinSubseq("bbabcbcab"));
        System.out.println(longestPalinSubseqDpTopDown("bbabcbcab"));
        System.out.println(longestPalinSubseqBottomUp("bbabcbcab"));
        System.out.println(longestPalinSubseqSpaceOptimized("bbabcbcab"));

    }

    /**
     * Recursion Approach
     * Time complexity: O(2^n)
     * Space complexity O(n)
     */

    public static int longestPalinSubseq(String s) {
        return recurse(s, 0, s.length() - 1);

    }

    public static int recurse(String s, int start, int end) {
        if (start == end)
            return 1;
        else if (start > end)
            return 0;
        else if (s.charAt(start) == s.charAt(end))
            return 2 + recurse(s, start + 1, end - 1);
        else
            return Math.max(recurse(s, start + 1, end), recurse(s, start, end - 1));
    }

    /**
     * Top Down Dp approach
     * time complexity O(n^2)
     * space complexity O(n^2)
     */
    public static int longestPalinSubseqDpTopDown(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        return topDownDp(s, 0, n - 1, dp);

    }

    public static int topDownDp(String s, int start, int end, int[][] dp) {
        if (start == end)
            dp[start][end] = 1;
        else if (start > end)
            dp[start][end] = 0;
        else if (dp[start][end] != -1)
            return dp[start][end];
        else if (s.charAt(start) == s.charAt(end))
            dp[start][end] = 2 + topDownDp(s, start + 1, end - 1, dp);
        else
            dp[start][end] = Math.max(topDownDp(s, start + 1, end, dp), topDownDp(s, start, end - 1, dp));

        return dp[start][end];
    }

    /**
     * DP Bottom Up approach
     * time complexity:O(n^2)
     * space complexity:O(n^2)
     * advantage call stack is not used
     */
    public static int longestPalinSubseqBottomUp(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = 1;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    // to avoid invalid index axis
                    if (len == 2)
                        dp[i][j] = 2;
                    else
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];

    }

    /**
     * DP Space Optimization
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public static int longestPalinSubseqSpaceOptimized(String s) {
        int n = s.length();
        int dp[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int prev = 0;

            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = prev + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[n - 1];

    }
}
