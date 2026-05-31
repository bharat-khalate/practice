 ;

/**
 * @Problem Given two strings denoting non-negative numbers s1 and s2. Calculate
 *          the sum of s1 and s2.
 * 
 * @Example Input: s1 = "25", s2 = "23"
 *          Output: "48"
 *          Explanation: The sum of 25 and 23 is 48.
 * 
 *          Input: s1 = "2500", s2 = "23"
 *          Output: "2523"
 *          Explanation: The sum of 2500 and 23 is 2523.
 * 
 *          Input: s1 = "2", s2 = "3"
 *          Output: "5"
 *          Explanation: The sum of 2 and 3 is 5.
 */
public class SumOfTwoLargeNum {
    public static void main(String[] args) {
        System.out.println(findSum("25", "23"));
    }

    static String findSum(String s1, String s2) {
        s1 = removeLeadingZeros(s1);
        s2 = removeLeadingZeros(s2);
        if (s1 == "" && s2 == "")
            return "0";
        int m = s1.length(), n = s2.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = m - 1, j = n - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0)
                sum += (s1.charAt(i--) - '0');
            if (j >= 0)
                sum += (s2.charAt(j--) - '0');
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }

    public static String removeLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '0')
            i++;
        return s.substring(i, s.length());
    }
}
