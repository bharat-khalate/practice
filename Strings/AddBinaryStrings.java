package Strings;

/**
 * @Problem Given two binary strings s1 and s2 consisting of only 0s and 1s.
 *          Find the resultant string after adding the two Binary Strings.
 *          Note: The input strings may contain leading zeros but the output
 *          string should not have any leading zeros.
 * 
 * @Example
 *          Input: s1 = "1101", s2 = "111"
 *          Output: 10100
 *          Explanation:
 *          1101
 *          + 111
 *          10100
 * 
 *          Input: s1 = "00100", s2 = "010"
 *          Output: 110
 *          Explanation:
 *          100
 *          + 10
 *          110
 */
public class AddBinaryStrings {
    public static void main(String[] args) {
        System.out.println(addBinary("1101", "111"));
    }

    public static String addBinary(String s1, String s2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int i = s1.length() - 1;
        int j = s2.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            if (i >= 0)
                sum += s1.charAt(i--) - '0';
            if (j >= 0)
                sum += s2.charAt(j--) - '0';

            sb.append(sum % 2);
            carry = sum / 2;
        }

        // reverse result
        String result = sb.reverse().toString();

        // 🔥 remove leading zeros
        int k = 0;
        while (k < result.length() - 1 && result.charAt(k) == '0') {
            k++;
        }

        return result.substring(k);
    }
}
