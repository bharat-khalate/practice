 ;

/**
 * @Problem Write code to convert a given number into words.
 * @Example Input: 438237764
 *          Output: forty three crore eighty two lakh thirty seven thousand
 *          seven hundred and sixty four
 * 
 *          Input: 999999
 *          Output: nine lakh ninety nine thousand nine hundred and ninety nine
 * 
 *          Input: 1000
 *          Output: one thousand
 *          Explanation: 1000 in words is "one thousand"
 */
public class NumberToWord {

    static String one[] = { "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ",
            "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ",
            "Nineteen " };
    static String ten[] = { "", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ",
            "Ninety " };

    public static void main(String args[]) {
        System.out.println(convertToWords(1000));
    }

    static String convertToWords(int n) {
        String res = "";
        if (n == 0)
            return "Zero";
        res += getWord((int) (n / 1000000), "Million ");
        res += getWord((int) (n / 100000) % 100, "Lakh ");
        res += getWord((int) (n / 1000) % 100, "Thousand ");
        res += getWord((int) (n / 100) % 10, "Hundred ");
        if (n > 100)
            res += "And ";
        res += getWord((int) (n % 100), "");
        return res.trim();
    }

    public static String getWord(int n, String s) {
        String out = "";
        if (n > 19) {
            out += ten[n / 10] + one[n % 10];
        } else {
            out += one[n];
        }
        if (n != 0)
            out += s;
        return out;
    }
}
