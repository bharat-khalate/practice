package Strings;

/**
 * Given two strings s1 and s2 of equal length, determine whether s2 is a
 * rotation of s1.
 * A string is said to be a rotation of another if it can be obtained by
 * shifting some leading characters of the original string to its end without
 * changing the order of characters.
 * 
 * @example
 *          Input: s1 = "abcd", s2 = "cdab"
 *          Output: true
 *          Explanation: After 2 right rotations, s1 will become equal to s2.
 * 
 *          Input: s1 = "aab", s2 = "aba"
 *          Output: true
 *          Explanation: After 1 left rotation, s1 will become equal to s2.
 * 
 *          Input: s1 = "abcd", s2 = "acbd"
 *          Output: false
 *          Explanation: Strings are not rotations of each other.
 */

public class CheckRotation {
    public static boolean areRotations(String s1, String s2) {
        String txt = s1 + s1;
        String pat = s2;
        int[] lps = computeLPS(pat);
        int m = txt.length();
        int n = pat.length();
        int j = 0;
        int i = 0;
        while (i < m) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j >= n) {
                return true;
            }
            if (i < m && txt.charAt(i) != pat.charAt(j)) {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public static int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String args[]) {
        String s1 = "abcd";
        String s2 = "cdab";
        System.out.println(areRotations(s1, s2));
    }
}
