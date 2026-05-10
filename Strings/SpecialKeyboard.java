package Strings;

/**
 * @Problem Given a special keyboard that contains only four keys:
 * 
 *          Key 1: Prints a single character 'A' on the screen.
 *          Key 2 (Ctrl + A): Selects all the characters currently present on
 *          the screen.
 *          Key 3 (Ctrl + C): Copies the selected characters to a buffer.
 *          Key 4 (Ctrl + V): Pastes the content of the buffer onto the screen,
 *          appending
 *          it to the existing text.
 *          Initially, the screen is empty and the buffer is also empty.
 * 
 *          Determine the maximum number of 'A' characters that can be displayed
 *          on the
 *          screen after performing exactly n key presses.
 * 
 * @Example Input: n = 3
 *          Output: 3
 *          Explanation: With only 3 key presses, the best option is to press
 *          Key 1 each time. So, the screen shows "AAA" and the total number of
 *          A’s is 3.
 * 
 *          Input: n = 7
 *          Output: 9
 *          Explanation: An optimal sequence is: press Key 1 three times to get
 *          "AAA", then use Key 2 (select all) and Key 3 (copy), followed by Key
 *          4 twice (paste). This results in "AAAAAAAAA", so the total number of
 *          A’s is 9.
 */
public class SpecialKeyboard {
    public static void main(String[] args) {
        System.out.println(optimalKeysBottomUpDp(0));
        System.out.println(optimalKeysRecursive(0));

    }

    public static int optimalKeysBottomUpDp(int n) {
        if (n < 7)
            return n;
        int dp[] = new int[n];

        for (int i = 1; i <= 6; i++)
            dp[i - 1] = i;
        for (int i = 7; i <= n; i++) {
            dp[i - 1] = Math.max(2 * dp[i - 4], Math.max(3 * dp[i - 5], 4 * dp[i - 6]));

        }
        return dp[n - 1];

    }

    public static int optimalKeysRecursive(int n) {
        if (n < 7)
            return n;
        int max = 0;
        for (int i = n - 3; i > 0; i--) {
            int curr = (n - i - 1) * optimalKeysRecursive(i);
            Math.max(curr, max);
        }
        return max;
    }
}
