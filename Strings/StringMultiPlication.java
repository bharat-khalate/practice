/**
 * Given: Two non-negative integers num1 and num2 represented as strings.
Goal: Return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integers directly.
Example 1:
•	Input: num1 = "2", num2 = "3"
•	Output: "6"

 */

package Strings;

public class StringMultiPlication {

    public static void main(String args[]) {
        String num1 = "123";
        String num2 = "78";
        int number1 = 0;
        int n2 = num2.length() - 1;
        int zerosAtLast = 1;
        int product = 0;

        for (int i = 0; i < num1.length(); i++) {
            number1 = number1 * 10 + (num1.charAt(i) - 48);
        }

        while (n2 >= 0) {
            int res = num2.charAt(n2) - 48;
            res = (res * number1) * zerosAtLast;
            zerosAtLast *= 10;
            product += res;
            n2--;
        }

        System.out.println(product);

    }
}

class StringProduct {
    public static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int[] result = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                int sum = d1 * d2 + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < result.length && result[i] == 0)
            i++;
        for (; i < result.length; i++) {
            sb.append(result[i]);
        }
        String resturnString = new String(sb);
        return sb.length() == 0 ? "0" : resturnString;
    }

    public static void main(String args[]) {
        System.out.println(multiply("123", "456"));
    }
}
