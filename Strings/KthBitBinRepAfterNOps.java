package Strings;

/**
 * @Problem Given a decimal number m. Consider its binary representation string
 *          and apply n iterations. In each iteration, replace the character 0
 *          with the string 01, and 1 with 10. Find the kth (1-based indexing)
 *          character in the string after the nth iteration
 * @Example Input: m = 5, n = 2, k = 5
 *          Output: 0
 *          Explanation: Binary representation of m is "101", after one
 *          iteration binary representation will be "100110", and after second
 *          iteration binary representation will be "100101101001".
 * 
 *          Input: m = 5, n = 2, k = 1
 *          Output: 1
 *          Explanation: Binary representation of m is "101", after one
 *          iteration binary representation will be "100110", and after second
 *          iteration binary representation will be "100101101001".
 */
public class KthBitBinRepAfterNOps {

    public static void main(String args[]) {
        int m = 5, n = 2, k = 5;
        System.out.println(getKthBit(m, n, k));
    }

    public static int getKthBit(int m, int n, int k) {
        String bin = getBinValue(m);
        int blockSize = 1 << n;
        k--;
        int baseIdx = bin.charAt(k / blockSize) - '0';
        int offSet = k % blockSize;
        return baseIdx ^ (popCount(offSet) % 2);
    }

    public static int popCount(int offset) {
        String bin = getBinValue(offset);
        int count = 0;
        for (int i = 0; i < bin.length(); i++)
            if (bin.charAt(i) == '1')
                count++;
        return count;
    }

    public static String getBinValue(int dec) {
        StringBuilder sb = new StringBuilder();
        while (dec > 0) {
            sb.append(dec % 2);
            dec /= 2;
        }
        return sb.reverse().toString();
    }
}
