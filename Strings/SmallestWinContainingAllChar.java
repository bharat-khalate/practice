package Strings;

/**
 * @Problem Given two strings s and p. Find the smallest substring in s
 *          consisting of all the characters (including duplicates) of the
 *          string p. Return empty string in case no such substring is present.
 *          If there are multiple such substring of the same length found,
 *          return the one with the least starting index.
 * @Example Input: s = "timetopractice", p = "toc"
 *          Output: "toprac"
 *          Explanation: "toprac" is the smallest substring in which "toc" can
 *          be found.
 * 
 *          Input: s = "zoomlazapzo", p = "oza"
 *          Output: "apzo"
 *          Explanation: "apzo" is the smallest substring in which "oza" can be
 *          found.
 * 
 *          Input: s = "zoom", p = "zooe"
 *          Output: ""
 *          Explanation: No substring is present containing all characters of p.
 */
public class SmallestWinContainingAllChar {
    public static void main(String[] args) {
        System.out.println(minWindow("timetopractice", "toc"));
    }

    public static String minWindow(String s, String p) {
        int freq[] = new int[256];
        int start = 0;
        int end = 0;
        int startIdx = 0;
        int len = Integer.MAX_VALUE;
        int count = p.length();
        for (char c : p.toCharArray()) {
            freq[c]++;
        }
        while (end < s.length()) {
            if (freq[s.charAt(end)] > 0) {
                count--;
            }
            freq[s.charAt(end)]--;

            while (count == 0) {
                if (end - start + 1 < len) {
                    len = end - start + 1;
                    startIdx = start;
                }
                freq[s.charAt(start)]++;
                if (freq[s.charAt(start)] > 0) {
                    count++;
                }
                start++;
            }
            end++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + len);
    }
}
