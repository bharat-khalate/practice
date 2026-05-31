import java.util.Arrays;

/**
 * @Problem Given a string s, write a program to delete the minimum number of
 *          characters from the string so that the resultant string is a
 *          palindrome, while maintaining the order of characters
 * @Example Input: s = "aebcbda"
 *          Output: 2
 *          Explanation: Remove characters 'e' and 'd'.
 * 
 *          Input: s = "geeksforgeeks"
 *          Output: 8
 *          Explanation: To make "geeksforgeeks" a palindrome, the longest
 *          palindromic subsequence is "eefee" (length 5). The minimum deletions
 *          are:
 *          13 (length of s) - 5 = 8.
 */
public class MinDeletionToFormPalindrome {
    public static void main(String args[]) {
        System.out.println(minDeletionsRecursive("aebcbda"));
        System.out.println(minDeletionsDpTopDown("aebcbda"));
        System.out.println(minDeletionsDpBottomUp("aebcbda"));
        System.out.println(minDeletionsDPSpaceOptimized("aebcbda"));
    }

    /**
     * Recursive approach
     * Time complexity O(2^n)
     * Space complexity O(2^n)
     */

    static int minDeletionsRecursive(String s) {
        int n = s.length();
        return n - deleteRecursively(s, 0, n - 1);

    }

    static int deleteRecursively(String s, int startIdx, int endIdx) {
        if (startIdx == endIdx)
            return 1;
        if (startIdx > endIdx)
            return 0;
        if (s.charAt(startIdx) == s.charAt(endIdx))
            return 2 + deleteRecursively(s, ++startIdx, --endIdx);
        return Math.max(deleteRecursively(s, startIdx + 1, endIdx), deleteRecursively(s, startIdx, endIdx - 1));
    }

    /**
     * DP Memoization/Top down approach
     * Time complexity O(n^2)
     * Space Complexity O(n^2)
     */
    static int minDeletionsDpTopDown(String s) {
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];
        for (int arr[] : dp)
            Arrays.fill(arr, -1);
        return n - deleteRecursively(s, 0, n - 1, dp);
    }

    static int deleteRecursively(String s, int startIdx, int endIdx, int dp[][]) {
        if (startIdx == endIdx) {
            dp[startIdx][endIdx] = 1;
            return 1;
        }
        if (startIdx > endIdx)
            return 0;
        if (dp[startIdx][endIdx] != -1)
            return dp[startIdx][endIdx];
        if (s.charAt(startIdx) == s.charAt(endIdx))
            dp[startIdx][endIdx] = 2 + deleteRecursively(s, startIdx + 1, endIdx - 1, dp);
        else
            dp[startIdx][endIdx] = Math.max(deleteRecursively(s, startIdx + 1, endIdx, dp),
                    deleteRecursively(s, startIdx, endIdx - 1, dp));
        return dp[startIdx][endIdx];
    }

    /**
     * DP Tabulation/Bottom Up Approach
     * Time Complexity O(n^2)
     * Space Complexity O(n^2)
     * advantage over top down: Saves stack space
     */
    static int minDeletionsDpBottomUp(String s) {
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++)
            dp[i][i] = 1;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                if (s.charAt(i) == s.charAt(i + len - 1)) {
                    if (len == 2) {
                        dp[i][i + len - 1] = 2;
                    } else {
                        dp[i][i + len - 1] = 2 + dp[i + 1][i + len - 2];
                    }
                } else {
                    dp[i][i + len - 1] = Math.max(dp[i + 1][i + len - 1], dp[i][i + len - 2]);
                }
            }
        }
        return n - dp[0][n - 1];
    }

    /**
     * DP Space Optimization
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    static int minDeletionsDPSpaceOptimized(String s) {
        int n = s.length();
        int dp[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int prev = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = 2 + prev;

                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return n - dp[n - 1];

    }
}
