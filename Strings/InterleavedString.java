 ;

import java.util.Arrays;

/**
 * @Problem Given strings s1, s2, and s3, find whether s3 is formed by an
 *          interleaving of s1 and s2.
 *          Interleaving of two strings s1 and s2 is a way to mix their
 *          characters to form a new string s3, while maintaining the relative
 *          order of characters from s1 and s2. Conditions for interleaving:
 * 
 *          Characters from s1 must appear in the same order in s3 as they are
 *          in s1.
 *          Characters from s2 must appear in the same order in s3 as they are
 *          in s2.
 *          The length of s3 must be equal to the combined length of s1 and s2.
 * 
 * @Example Input: s1 = "AAB", s2 = "AAC", s3 = "AAAABC"
 *          Output: true
 *          Explanation: The string "AAAABC" has all characters of the other two
 *          strings and in the same order.
 * 
 *          Input: s1 = "AB", s2 = "C", s3 = "ACB"
 *          Output: true
 *          Explanation: s3 has all characters of s1 and s2 and retains order of
 *          characters of s1.
 * 
 *          Input: s1 = "YX", s2 = "X", s3 = "XXY"
 *          Output: false
 *          Explanation: "XXY " is not interleaved of "YX" and "X". The strings
 *          that can be formed are YXX and XYX
 */
public class InterleavedString {
    public static void main(String[] args) {
        System.out.println(isInterleaveTopDown("AAB", "AAC", "AAAABC"));
        System.out.println(isInterleaveBottomUp("AAB", "AAC", "AAAABC"));
    }

    public static boolean isInterleaveBottomUp(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length())
            return false;
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++)
            dp[0][j] = (s2.charAt(j - 1) == s3.charAt(j - 1)) && dp[0][j - 1];
        for (int i = 1; i <= m; i++)
            dp[i][0] = (s1.charAt(i - 1) == s3.charAt(i - 1)) && dp[i - 1][0];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int k = i + j - 1;
                dp[i][j] = (s1.charAt(i - 1) == s3.charAt(k) && dp[i - 1][j])
                        || (s2.charAt(j - 1) == s3.charAt(k) && dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    public static boolean isInterleaveTopDown(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        for (int arr[] : dp)
            Arrays.fill(arr, -1);
        return recursiveCheckForTopDown(0, 0, s1, s2, s3, dp);
    }

    public static boolean recursiveCheckForTopDown(int i, int j, String s1, String s2, String s3, int[][] dp) {
        int k = i + j;
        if (i == s1.length() && j == s2.length() && k == s3.length())
            return true;
        boolean ans1 = false;
        boolean ans2 = false;
        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        if ((i < s1.length() && s1.charAt(i) == s3.charAt(k)))
            ans1 = recursiveCheckForTopDown(i + 1, j, s1, s2, s3, dp);
        if ((j < s2.length() && s2.charAt(j) == s3.charAt(k)))
            ans2 = recursiveCheckForTopDown(i, j + 1, s1, s2, s3, dp);
        dp[i][j] = (ans1 || ans2) ? 1 : 0;
        return ans1 || ans2;
    }
}