package Strings;

/**
 * @Problem Given two strings s1 and s2, find the minimum number of times s1
 *          must be repeated so that s2 becomes a substring of the resulting
 *          string.
 *          If it is not possible for s2 to be a substring, return -1.
 * 
 * @Example Input: s1 = "abac", s2 = "cabaca"
 *          Output: 3
 *          Explanation: After repeating s1 three times, s1 will become
 *          “abacabacabac”. Now, s2 is now a substring of s1 = "abacabacabac".
 *          Also s2 is not a substring of s1 when it is repeated less than 3
 *          times.
 * 
 *          Input: s1 = "ab", s2 = "cab"
 *          Output : -1
 *          Explanation: s2 can not become a substring of s1 after any
 *          repetition of s1.
 */
public class MinRepeatsForSubStringMatch {
    public static void main(String[] args) {
        System.out.println(countRepetitions("abac", "cabaca"));
        System.out.println(countRepetitions("ab", "cab"));
    }

    public static int countRepetitions(String text, String pat) {
        int lps[] = computeLPS(pat);
        int x = ((pat.length() + text.length() - 1) / text.length())+1;
        int i = 0;
        int j = 0;
        while (i < text.length() * x) {
            if (text.charAt(i % text.length()) == pat.charAt(j)) {
                j++;
                i++;
                if (j == pat.length()) {
                    return (i + text.length() - 1) / text.length();
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    public static int[] computeLPS(String pat) {
        int n = pat.length();
        int lps[] = new int[n];
        int i = 1;
        lps[0] = 0;
        int len = 0;
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }
}
