package Strings;

/**
 * @Problem Given three strings s, s1, and s2 of lengths n, m, and k
 *          respectively, the task is to modify the string s by replacing all
 *          the substrings s1 with the string s2 in the string s.
 * 
 * @Example Input: s = "abababa", s1 = "aba", s2 = "a"
 *          Output: aba
 *          Explanation: Change the substrings s[0, 2] and s[4, 6] to the string
 *          s2 modifies the string s to "aba".
 * 
 *          Input: s = "geeksforgeeks", s1 = "eek", s2 = "ok"
 *          Output: goksforgoks
 *          Explanation: Change the substrings s[1, 3] and s[9, 11] to the
 *          string
 */
public class ReplaceSubStrOccurrence {
    public static void main(String args[]) {
        System.out.println(replaceStr("geeksforgeeks", "eek", "ok"));
    }

    public static String replaceStr(String str, String s1, String s) {
        int lps[] = generateLPS(s1);
        StringBuilder sb = new StringBuilder();
        int i = 0;// pointing str
        int j = 0;// pointing s1
        while (i < str.length()) {
            if (str.charAt(i) == s1.charAt(j)) {
                i++;
                j++;
                if (j == s1.length()) {
                    sb.append(s);
                    j = 0;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    sb.append(str.charAt(i));
                    i++;   
                }
            }
        }
        if(j>0)
        sb.append(s1.substring(0, j));
        return sb.toString();
    }

    public static int[] generateLPS(String pat) {
        int n = pat.length();
        int[] lps = new int[n];
        int len = 0;
        lps[0] = 0;
        int i = 1;
        while (i < n) {
            if (pat.charAt(len) == pat.charAt(i)) {
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
}