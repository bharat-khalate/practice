 ;

import java.util.Stack;

/**
 * @Problem Given a string s consisting only of opening and closing parentheses
 *          '(' and ')', find the length of the longest valid (well-formed)
 *          parentheses substring.
 * 
 *          Note: The length of the smallest valid substring "()" is 2.
 * 
 * @Example Input: s = "(()("
 *          Output: 2
 *          Explanation: The longest valid substring is "()". Its length is 2.
 * 
 *          Input: s = "()(())("
 *          Output: 6
 *          Explanation: The longest valid substring is "()(())". Its length is
 *          6.
 * 
 *          Input: s = "(()())"
 *          Output: 6
 *          Explanation: The longest valid substring is "(()())". Its length is
 *          6.
 */
public class ValidParenthesisSubstring {
    public static void main(String[] args) {
        System.out.println(maxLengthStack("()(())"));
        System.out.println(maxLengthDP("()(())"));
        System.out.println(maxLengthTwoTraversal("()(())"));
    }

    /**
     * Stack approach
     * time complexity O(n)
     * space complexity O(n)
     */
    public static int maxLengthStack(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }
        return ans;
    }

    /**
     * DP Bottom Up approach
     * Time complexity O(n)
     * Space Complexity O(n)
     */
    public static int maxLengthDP(String s) {
        int n = s.length();
        int ans = 0;
        int dp[] = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    if (i - dp[i - 1] >= 2) {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /**
     * Two traversal method
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int maxLengthTwoTraversal(String s) {
        int n = s.length();
        int ans = 0;
        int open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                open++;
            else
                close++;
            if (open == close)
                ans = Math.max(ans, 2 * close);
            if (close > open)
                open = close = 0;
        }
        open = close = 0;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')')
                close++;
            else
                open++;
            if (open == close)
                ans = Math.max(ans, 2 * open);
            if (open > close)
                open = close = 0;
        }
        return ans;
    }
}