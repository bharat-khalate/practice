 ;

/**
 * @Problem Given two numbers as strings s1 and s2. Calculate their Product.
 *          Note: The numbers can be negative and You are not allowed to use any
 *          built-in function or convert the strings to integers. There can be
 *          zeros in the begining of the numbers. You don't need to specify '+'
 *          sign in the begining of positive numbers.
 * 
 * @Example Input: s1 = "0033", s2 = "2"
 *          Output: "66"
 *          Explanation: 33 * 2 = 66
 * 
 *          Input: s1 = "11", s2 = "23"
 *          Output: "253"
 *          Explanation: 11 * 23 = 253
 * 
 *          Input: s1 = "123", s2 = "0"
 *          Output: "0"
 *          Explanation: Anything multiplied by 0 is equal to 0.
 */
public class MultiplyTwoStrings {
    public static void main(String[] args) {
        String s1 = "0033", s2 = "2";
        System.out.println(multiplyStrings(s1, s2));
    }

    public static String multiplyStrings(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        if (m == 0 || n == 0)
            return "0";
        int isS1Neg = s1.charAt(0) == '-' ? -1 : 1;
        int isS2Neg = s2.charAt(0) == '-' ? -1 : 1;
        int isResNeg = isS1Neg * isS2Neg;
        int arr[] = new int[m + n];
        int i1 = 0;
        int i2 = 0;
        for (int i = m - 1; i >= 0; i--) {
            if (s1.charAt(i) == '-')
                continue;
            int carry = 0;
            int num1 = s1.charAt(i) - '0';
            i2 = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (s2.charAt(j) == '-')
                    continue;
                int num2 = s2.charAt(j) - '0';
                int product = num1 * num2 + arr[i1 + i2] + carry;
                arr[i1 + i2] = product % 10;
                carry = product / 10;
                i2++;
            }
            if (carry > 0) {
                arr[i1 + i2] += carry;
            }
            i1++;
        }
        int i = arr.length - 1;
        while (i >= 0 && arr[i] == 0)
            i--;
        if (i == -1)
            return "0";
        StringBuilder sb = new StringBuilder();
        for (int j = i; j >= 0; j--)
            sb.append(arr[j]);
        if (isResNeg == -1)
            return "-" + sb.toString();
        return sb.toString();
    }

}
