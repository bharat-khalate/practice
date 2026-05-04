package Strings;

/**
 * Given a string s, convert it into a 32-bit signed integer (similar to the
 * atoi() function) without using any built-in conversion functions.
 * The conversion follows these rules:
 * 
 * Ignore Leading Whitespaces: Skip all leading whitespace characters.
 * Check Sign: If the next character is either '+' or '-', take it as the sign
 * of the number. If no sign is present, assume the number is positive.
 * Read Digits: Read the digits and ignore any leading zeros. Stop reading when
 * a non-digit character is encountered or the end of the string is reached. If
 * no digits are found, return 0.
 * Handle Overflow: If the number exceeds the range of a 32-bit signed integer:
 * Return 2³¹ − 1 (i.e., 2147483647) if it is greater than the maximum value.
 * Return −2³¹ (i.e., -2147483648) if it is smaller than the minimum value.
 * 
 * @example
 *          Input: s = "-123"
 *          Output: -123
 *          Explanation: It is possible to convert -123 into an integer so we
 *          returned in the form of an integer
 * 
 *          Input: s = " -"
 *          Output: 0
 *          Explanation: No digits are present, therefore the returned answer is
 *          0.
 * 
 *          Input: s = " 1231231231311133"
 *          Output: 2147483647
 *          Explanation: The converted number will be greater than 231 – 1,
 *          therefore print 231 – 1 = 2147483647.
 */
public class Atoi {
    public static int myAtoi(String s) {
        int res = 0;
        boolean isNegative = false;
        int i = 0;
        int n = s.length();
        while (s.charAt(i) == ' ') {
            i++;
        }
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            isNegative = s.charAt(i) == '-';
            i++;
        }
        while (i < n && Character.isDigit(s.charAt(i))) {
            int current = s.charAt(i) - '0';
            long temp = (long) res * 10 + current;
            if (!isNegative && temp > 2147483647) {
                return 2147483647;
            }
            if (isNegative && temp * -1 < -2147483648) {
                return -2147483648;
            }
            res = (int) temp;
            i++;
        }
        return isNegative ? -1 * res : res;
    }
    public static void main(String args[]) {
        System.out.println(myAtoi("-123"));
    }
}
