package Strings;

/**
 * You are given a string S. Every sub-string of identical letters is replaced
 * by a single instance of that letter followed by the hexadecimal
 * representation of the number of occurrences of that letter. Then, the string
 * thus obtained is further encrypted by reversing it [ See the sample for more
 * clarity ]. Print the Encrypted String.
 * 
 * Note: All Hexadecimal letters should be converted to Lowercase letters
 * 
 * @example
 *          Input:
 *          S = "aaaaaaaaaaa"
 *          Output:
 *          ba
 *          Explanation:
 *          aaaaaaaaaaa
 *          Step1: a11 (a occurs 11 times)
 *          Step2: a11 is ab [since 11 is b in
 *          hexadecimal]
 *          Step3: ba [After reversing]
 * 
 *          Input:
 *          S = "abc"
 *          Output:
 *          1c1b1a
 *          Explanation:
 *          abc
 *          Step1: a1b1c1
 *          Step2: 1c1b1a [After reversing]
 * 
 *NOTE: the count of group is separate i.e aba will be a1b1a1
 */
class EncryptStringII {
    public static void main(String args[]) {

    }

    static String encryptString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = s.length();

        while (i < n) {
            char cur = s.charAt(i++);
            int count = 1;
            while (i < n && s.charAt(i) == cur) {
                count++;
                i++;
            }
            sb.append(cur);
            sb.append(getHexValue(count));
        }
        return sb.reverse().toString();
    }

    static String getHexValue(int decimalNumber) {
        if (decimalNumber == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 16;
            if (remainder < 10) {
                sb.append((char) ('0' + remainder));
            } else {
                sb.append((char) ('a' + (remainder - 10)));
            }

            decimalNumber /= 16;
        }
        return sb.toString();
    }
}