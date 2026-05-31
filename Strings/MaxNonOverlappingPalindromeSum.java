package Strings;

/**
 * @Problem Given a string s consisting of lowercase English letters, find the
 *          maximum possible sum of the lengths of any two non-empty and
 *          non-overlapping palindromic substrings of odd length.
 * 
 *          Formally, choose any two substrings s[i...j] and s[k...l] such that
 *          1 ≤ i ≤ j < k ≤ l ≤ s.size(), both substrings are palindromes of odd
 *          length, and they do not overlap. Return the maximum sum of their
 *          lengths.
 * 
 *          Note: A palindrome is a string that reads the same forward and
 *          backward. A substring is a contiguous sequence of characters within
 *          the string.
 * 
 * @Example Input: s = "xyabacbcz"
 *          Output: 6
 *          Explanation: "aba" and "cbc" are non-overlapping odd-length
 *          palindromes. Their lengths are 3 and 3 which gives the sum as 6.
 * 
 *          Input: s = "gfgforgeeks"
 *          Output: 4
 *          Explanation: "gfg" and "g" are non-overlapping odd-length
 *          palindromes. Their lengths are 3 and 1 which gives the sum as 4.
 */
public class MaxNonOverlappingPalindromeSum {
    static int arr[];

    public static void main(String[] args) {
        System.out.println(maxSum("gfgforgeeks"));
    }

    public static int maxSum(String s) {
        int n = s.length();
        int leftMark[] = new int[n];
        int rightMark[] = new int[n];
        calculateManachers(s);

        for (int i = 0; i < n; i++) {
            int val = getLongestPalindrome(i, 1);
            int li = i + val / 2;
            if (li < n)
                leftMark[li] = Math.max(leftMark[li], val);
        }
        for (int i = n - 2; i >= 0; i--)
            leftMark[i] = Math.max(leftMark[i], leftMark[i + 1] - 2);
        for (int i = 1; i < n; i++)
            leftMark[i] = Math.max(leftMark[i - 1], leftMark[i]);
        for (int j = n - 1; j >= 0; j--) {
            int val = getLongestPalindrome(j, 1);
            int ri = j - val / 2;
            if (ri >= 0)
                rightMark[ri] = Math.max(rightMark[ri], val);
        }
        for (int j = 1; j < n; j++)
            rightMark[j] = Math.max(rightMark[j], rightMark[j - 1] - 2);
        for (int j = n - 2; j >= 0; j--)
            rightMark[j] = Math.max(rightMark[j], rightMark[j + 1]);
        int ans = 2;
        for (int i = 0; i + 1 < n; i++)
            ans = Math.max(ans, leftMark[i] + rightMark[i + 1]);
        return ans;
    }

    public static int getLongestPalindrome(int center, int flag) {
        int pos = 2 * center + 2 + (flag == 1 ? 0 : 1);
        return arr[pos];
    }

    public static void calculateManachers(String s) {
        s = prepareString(s);
        int n = s.length();
        arr = new int[n];
        int center = 0;
        int right = 0;
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;
            if (i < right) {
                arr[i] = Math.min(arr[mirror], right - i);
            }
            while (s.charAt(i - arr[i] - 1) == s.charAt(i + arr[i] + 1))
                arr[i]++;
            if (i + arr[i] > right) {
                right = arr[i] + i;
                center = i;
            }
        }

    }

    public static String prepareString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("@");
        for (char c : s.toCharArray()) {
            sb.append("#");
            sb.append(c);
        }
        sb.append("#$");
        return sb.toString();
    }
}