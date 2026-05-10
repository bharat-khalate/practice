package Strings;

/**
 * @Problem Given a string s, find the length of the longest substring without
 *          repeating characters.
 * 
 * @Example Input: s = "geeksforgeeks"
 *          Output: 7
 *          Explanation: Longest substring is "eksforg".
 * 
 *          Input: s = "abdefgabef"
 *          Output: 6
 *          Explanation: Longest substring are "abdefg" , "bdefga" and "defgab".
 * 
 *          Input: s = "aaaaa"
 *          Output: 1
 *          Explanation: Longest substring is "a".
 */
public class LengthOfLongestSubString {
    public static void main(String[] args) {
        System.out.println(longestUniqueSubstring("geeksforgeeks"));
    }
    static int longestUniqueSubstring(String s) {
        boolean arr[] = new boolean[256];
        int start = 0;
        int end = 0;
        int maxLen = 0;
        while (end < s.length()) {
            while (arr[s.charAt(end)]) {
                arr[s.charAt(start)] = false;
                start++;
            }
            arr[s.charAt(end)] = true;
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}
