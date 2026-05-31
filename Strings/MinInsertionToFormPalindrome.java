package Strings;

import java.util.Arrays;

/**
 * @Problem Given a string s, the task is to find the minimum number of
 *          characters to be inserted to convert it to a palindrome.
 * 
 *          Note: A palindrome is a string that reads the same backward as
 *          forward for example, strings "aba", "abccba" are palindromes
 * 
 * @Example Input: s = "abcd"
 *          Output: 3
 *          Explanation: Here we can append 3 characters in the beginning and
 *          the resultant string will be a palindrome "dcbabcd".
 *
 *          Input: s = "aba"
 *          Output: 0
 *          Explanation: Given string is already a palindrome hence no
 *          insertions are required.
 */
public class MinInsertionToFormPalindrome {
    public static void main(String[] args) {
        System.out.println(findMinInsertionsRecursively("abcd"));
        System.out.println(findMinInsertionsDpTopDown("abcd"));
        System.out.println(findMinInsertionsDPSpaceOptimization("abcd"));
    }

    /**
     * Using Recursive approach
     * Time Complexity O(2^n)
     * Space Complexity O(2^n)
     */
    /**
     * function to trigger palindrome insertion check
     * 
     * @param s String- string in which insertion going to be done
     * @return int- minimum number of character needed to be inserted to make s
     *         palindrome
     */
    static int findMinInsertionsRecursively(String s) {
        return findRecursively(s, 0, s.length() - 1);
    }

    public static int findRecursively(String s, int startIdx, int endIdx) {
        if (startIdx > endIdx)
            return 0;
        if (s.charAt(startIdx) == s.charAt(endIdx))
            return findRecursively(s, startIdx + 1, endIdx - 1);
        return 1 + Math.min(findRecursively(s, startIdx + 1, endIdx), findRecursively(s, startIdx, endIdx - 1));
    }

    /**
     * DP Top down approach
     * Time COmplexity O(n^2)
     * Space Complexity O(n^2)
     */
    static int findMinInsertionsDpTopDown(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int arr[] : dp)
            Arrays.fill(arr, -1);
        return findRecursivelyBottomUp(s, 0, n - 1, dp);
    }

    public static int findRecursivelyBottomUp(String s, int startIdx, int endIdx, int dp[][]) {
        if (startIdx > endIdx) {
            return 0;
        }
        if (dp[startIdx][endIdx] != -1)
            return dp[startIdx][endIdx];
        if (s.charAt(startIdx) == s.charAt(endIdx))
            dp[startIdx][endIdx] = findRecursivelyBottomUp(s, startIdx + 1, endIdx - 1, dp);
        else
            dp[startIdx][endIdx] = 1 + Math.min(findRecursivelyBottomUp(s, startIdx + 1, endIdx, dp),
                    findRecursivelyBottomUp(s, startIdx, endIdx - 1, dp));
        return dp[startIdx][endIdx];
    }

    /**
     * DP Bottom UP Approach
     * Time complexity O(2^n)
     * Space complexity O(2^n)
     * advantage over top down- saves stack space
     */

    static int findMinInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    /**
     * DP Space Optimization
     * Time complexity O(n^2)
     * Space Complexity O(n)
     */
    static int findMinInsertionsDPSpaceOptimization(String s) {
        int n = s.length();
        int dp[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int prev = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = prev;
                } else {
                    dp[j] = 1 + Math.min(dp[j], dp[j - 1]);
                }
                prev = temp;
            }
        }
        return dp[n - 1];
    }

}