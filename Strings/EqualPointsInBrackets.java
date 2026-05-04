package Strings;

/**
 * @problem Given a string str of opening and closing brackets '(' and ')' only.
 *          The task is to find an equal point. An equal point is an index
 *          (0-based) such that the number of closing brackets on the right from
 *          that point must be equal to the number of opening brackets before
 *          that point
 * @example Input: str = "(())))("
 *          Output: 4
 *          Explanation: After index 4, string splits into (()) and ))(. Number
 *          of opening brackets in the first part is equal to number of closing
 *          brackets in the second part.
 * 
 *          Input : str = "))"
 *          Output: 2
 *          Explanation: As after 2nd position i.e. )) and "empty" string will
 *          be split into these two parts: So, in this number of opening
 *          brackets i.e. 0 in the first part is equal to number of closing
 *          brackets in the second part i.e. also 0.
 */
public class EqualPointsInBrackets {
    public static void main(String args[]) {
        System.out.println(countSub("(())))("));
    }

    public static long countSub(String s) {
        int n = s.length(), openCnt = 0, closeCnt = 0;
        for (int i = 0; i < n; i++)
            if (s.charAt(i) == ')')
                closeCnt++;
        int tempCloseCnt = closeCnt;
        for (int i = 0; i < n; i++) {
            if (openCnt == closeCnt)
                return i;
            if (s.charAt(i) == '(')
                openCnt++;
            if (s.charAt(i) == ')')
                closeCnt--;
        }
        if (tempCloseCnt > 0)
            return n;
        return 0;
    }
}
