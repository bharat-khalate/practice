 ;

import java.util.*;

/**
 * @Problem Given two strings, a text string txt and a pattern string pat, both
 *          consisting of lowercase English alphabets. Return the starting
 *          indices (0-based) of all the occurrences of the pattern string pat
 *          in the text string txt.
 * 
 *          Note: Return an empty list in case of no occurrences of pattern.
 * 
 * @Example Input: txt = "geeksforgeeks", pat = "geek"
 *          Output: [0, 8]
 *          Explanation: The string "geek" occurs twice in txt, one starts at
 *          index 0 and the other at index 8.
 * 
 *          Input: txt = "abesdu", pat = "edu"
 *          Output: []
 *          Explanation: There's no substring "edu" present in txt.
 * 
 *          Input: txt = "aabaacaadaabaaba", pat = "aaba"
 *          Output: [0, 9, 12]
 *          Explanation:
 *
 */
class RabinKarp {
    public static void main(String[] args) {
        System.out.println(search("geek", "geeksforgeeks"));
    }

    static ArrayList<Integer> search(String pat, String txt) {

        ArrayList<Integer> res = new ArrayList<>();

        int m = pat.length();
        int n = txt.length();

        long d = 256;
        long q = 1000000007L;

        long h = 1;

        for (int i = 0; i < m - 1; i++)
            h = (h * d) % q;

        long pHash = 0;
        long tHash = 0;

        // Initial hash
        for (int i = 0; i < m; i++) {
            pHash = (d * pHash + pat.charAt(i)) % q;
            tHash = (d * tHash + txt.charAt(i)) % q;
        }

        // Sliding window
        for (int i = 0; i <= n - m; i++) {

            // Hash match
            if (pHash == tHash) {

                boolean isMatch = true;

                for (int j = 0; j < m; j++) {

                    if (pat.charAt(j) != txt.charAt(i + j)) {
                        isMatch = false;
                        break;
                    }
                }

                if (isMatch)
                    res.add(i);
            }

            // Rolling hash update
            if (i < n - m) {

                tHash = (d * (tHash - txt.charAt(i) * h)
                        + txt.charAt(i + m)) % q;

                if (tHash < 0)
                    tHash += q;
            }
        }

        return res;
    }

}