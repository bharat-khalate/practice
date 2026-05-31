 ;

/**
 * @Problem Given a palindromic number N in the form of string. The task is to
 *          find the smallest palindromic number greater than N using the same
 *          set of digits as in N.
 * @Example Input:
 *          N = "35453"
 *          Output:
 *          53435
 *          Explanation: Next higher palindromic
 *          number is 53435.
 * 
 *          Input: N = "33"
 *          Output: -1
 *          Explanation: Next higher palindromic number
 *          does not exist.
 */
public class NextSmallestPalindrome {

    public static void main(String[] args) {
        System.out.println("35453");
    }

    public static String nextPalin(String N) {
        int n = N.length();
        if (n < 4)
            return "-1";
        char arr[] = N.toCharArray();
        int mid = n / 2 - 1;
        int i = mid - 1;
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;
        if (i < 0)
            return "-1";
        int smallest = mid;
        while (smallest > i && arr[smallest] <= arr[i])
            smallest--;
        if (smallest == i)
            return "-1";

        char temp = arr[i];
        arr[i] = arr[smallest];
        arr[smallest] = temp;

        temp = arr[n - i - 1];
        arr[n - i - 1] = arr[n - smallest - 1];
        arr[n - smallest - 1] = temp;

        reverse(arr, i + 1, mid);
        if (n % 2 == 0)
            reverse(arr, mid + 1, n - i - 2);
        else
            reverse(arr, mid + 2, n - i - 2);
        return new String(arr);
    }

    public static void reverse(char[] arr, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            char temp = arr[startIdx];
            arr[startIdx] = arr[endIdx];
            arr[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
    }
}