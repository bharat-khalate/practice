 ;

import java.util.Stack;

/**
 * @Problem Given a string s and an integer k, the task is to reduce the string
 *          by removing k consecutive identical characters. The removal
 *          operation can be performed any number of times until it is no longer
 *          possible.
 * 
 * @Example Input: k = 2, s = "geeksforgeeks"
 *          Output: gksforgks
 *          Explanation: Modified String after each step:
 *          "geeksforgeeks" -> "gksforgks"
 * 
 *          Input: k = 2, s = "geegsforgeeeks"
 *          Output: sforgeks
 *          Explanation: Modified String after each step:
 *          "geegsforgeeeks" -> "ggsforgeks" -> "sforgeks"
 * 
 *          Input: k = 2, s = "abbac"
 *          Output: c
 */
public class RepeatedlyRemoveKDuplicates {
    public static void main(String[] args) {
        System.out.println(reducedString(2, "geeksforgeeks"));
    }

    public static String reducedString(int k, String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            st.push(c);
            int count = 0;
            while (!st.isEmpty() && st.peek() == c) {
                st.pop();
                count++;
            }
            if (count == k)
                continue;
            else
                while (count > 0) {
                    st.push(c);
                    count--;
                }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();

    }

}