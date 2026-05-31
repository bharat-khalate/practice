 ;

import java.util.Arrays;

/**
 * @Problem Given two strings s1 and s2, find the length of the smallest string
 *          which has both s1 and s2 as its sub-sequences.
 *          Note: s1 and s2 can have both uppercase and lowercase English
 *          letters.
 * 
 * @Example Input: s1 = "geek", s2 = "eke"
 *          Output: 5
 *          Explanation: String "geeke" has both string "geek" and "eke" as
 *          subsequences.
 * 
 *          Input: s1 = "AGGTAB", s2 = "GXTXAYB"
 *          Output: 9
 *          Explanation: String "AGXGTXAYB" has both string "AGGTAB" and
 *          "GXTXAYB" as subsequences.
 * 
 *          Input: s1 = "geek", s2 = "ek"
 *          Output: 4
 *          Explanation: String "geek" has both string "geek" and "ek" as
 *          subsequences.
 */
public class ShortestCommonSuperSequence {
    public static void main(String args[]) {
        String s1 = "geek";
        String s2 = "eke";
        System.out.println(minSuperSeqRec(s1, s2));
        System.out.println(minSuperSeqDpTopDown(s1, s2));
        System.out.println(minSuperSeqSpaceOptimized(s1, s2));
    }

    /**
     * Recursive approach
     * Time complexity: O(2^(m+n))
     * Space complexity: O(m+n) recursive stack space
     */
    public static int minSuperSeqRec(String s1, String s2) {
        return recursiveCalculation(s1, s2, s1.length(), s2.length());
    }

    public static int recursiveCalculation(String s1, String s2, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + recursiveCalculation(s1, s2, m - 1, n - 1);

        return 1 + Math.min(recursiveCalculation(s1, s2, m - 1, n), recursiveCalculation(s1, s2, m, n - 1));
    }

    /**
     * DP Top down approach
     * Time complexity: O(n*m)
     * Space complexity: O(n*m)
     * not Auxiliary space complexity that is not counted (call stack for function
     * call) o(m+n) so total space complexity is O(m*n)+O(m+n)
     * advantage over recursion: Top down ensure every node value calculated once
     */
    public static int minSuperSeqDpTopDown(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        return dpTopDownCalculation(s1, s2, m, n, dp);
    }

    public static int dpTopDownCalculation(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            dp[m][n] = 1 + dpTopDownCalculation(s1, s2, m - 1, n - 1, dp);
        else
            dp[m][n] = 1
                    + Math.min(dpTopDownCalculation(s1, s2, m - 1, n, dp), dpTopDownCalculation(s1, s2, m, n - 1, dp));
        return dp[m][n];
    }

    /**
     * DP Bottom Up approach
     * time complexity: O(m*n)
     * space complexity: O(m*n)
     * advantage over top down DP: no extra stack space O(m+n) as no recursion
     */

    public static int minSuperSeqBottomUp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    /**
     * DP Space Optimization technique
     * Time complexity: O(m*n)
     * Space complexity: O(n)
     */

    public static int minSuperSeqSpaceOptimized(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp1[] = new int[n + 1];
        int dp2[] = new int[n + 1];
        dp1[0] = 0;
        dp2[0] = 0;
        for (int i = 1; i <= n; i++)
            dp1[i] = i;
        for (int i = 1; i <= m; i++) {
            dp2[0] = i;
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp2[j] = 1 + dp1[j - 1];
                else
                    dp2[j] = 1 + Math.min(dp1[j], dp2[j - 1]);
            }
            dp1 = dp2.clone();
        }
        return dp2[n];
    }
}
