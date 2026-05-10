package Strings;

/**
 * @Problem Given a positive integer n, return its corresponding Excel column
 *          title. In
 *          Excel, column titles follow this pattern:
 *          A, B, C, ..., Z, AA, AB, ..., AZ, BA, ..., ZZ, AAA, AAB, ...
 *          This is similar to a base-26 numbering system, but instead of digits
 *          0–25,
 *          the letters A–Z represent values 1–26.
 * 
 * @Example Input: n = 28
 *          Output: AB
 *          Explanation: 1 to 26 are A to Z, then 27 is AA and 28 is AB.
 *          Input: n = 13
 *          Output: M
 * 
 * 
 *          Explanation: M is the 13th character of alphabet.
 *          Input: n = 5473578
 *          Output: KYJZF
 * 
 */
public class NumberToExcelColumn {
    public static void main(String[] args) {
        System.out.println(5473578);
    }

    public static String colName(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) ('A' + n % 26));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}
