 ;

import java.util.ArrayList;
import java.util.List;

/**
 * @Problem Given two strings txt and pat, the task is to return all indices of
 *          occurrences of pat within txt.
 * 
 * @Example Input: txt = "abcab", pat = "ab"
 *          Output: [0, 3]
 *          Explanation: The string "ab" occurs twice in txt, first occurrence
 *          starts from index 0 and second from index 3.
 * 
 *          Input: txt= "aabaacaadaabaaba", pat = "aaba"
 *          Output: [0, 9, 12]
 *          Explanation:
 */
public class KmpMatchingIndex {
    public static void main(String[] args) {
        System.out.println(KMPSearch("ab","abcab"));
    }

    static void computeLPSArray(String pat, int M, int lps[]) {

        lps[0] = 0;
        int i = 1;
        int len = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i++] = len;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    static List<Integer> KMPSearch(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        int lps[] = new int[m];
        List<Integer> numList = new ArrayList<>();

        computeLPSArray(pat, m, lps);
        int i = 0, j = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                if (++j == m) {
                    numList.add(i - j);
                    j = 0;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return numList;
    }
}
