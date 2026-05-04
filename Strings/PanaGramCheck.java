package Strings;

/**
 * @Problem Given a string s, check if it is a "Panagram" or not. Return true if
 *          the string is a Panagram, else return false.
 *          A "Panagram" is a sentence containing every letter in the English
 *          Alphabet either in lowercase or Uppercase.
 * @Example Input: s = "Bawds jog, flick quartz, vex nymph"
 *          Output: true
 *          Explanation: In the given string, there are all the letters of the
 *          English alphabet. Hence, the output is true.
 * @Example Input: s = "sdfs"
 *          Output: false
 *          Explanation: In the given string, there aren't all the letters
 *          present in the English alphabet. Hence, the output is false.
 */

public class PanaGramCheck {
    public static void main(String args[]) {
        System.out.println(checkPangram("Bawds jog, flick quartz, vex nymph"));
    }

    public static boolean checkPangram(String s) {
        boolean arr[] = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                arr[c - 'a'] = true;
            } else if (c >= 'A' && c <= 'Z') {
                arr[c - 'A'] = true;
            } else
                continue;
        }
        for (boolean isValid : arr)
            if (!isValid)
                return false;
        return true;
    }
}
