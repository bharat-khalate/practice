import java.util.ArrayList;

public class PalinDromeSubstringQueries {
    /**
     * @Problem Given a string s and a 2D list queries[][] of size q,
     *          where each queries[i] consists of two integers [left, right].
     *          Each query refers to the substring s[left : right],
     *          where both left and right are inclusive (0-based indexing).
     *          For each query, find whether the substring s[left : right] forms a
     *          palindrome.
     * @Example Input: s = "abaaabaaaba", queries[][] = [[0, 10], [5, 8], [2, 5],
     *          [5, 9]]
     *          Output: [1, 0, 0, 1]
     *          Explanation: Lets process all the queries one by one:
     *          [0, 10]: The substring is "abaaabaaaba" which is a palindrome.
     *          [5, 8]: The substring is "baaa" which is not a palindrome.
     *          [2, 5]: The substring is "aaab" which is not a palindrome.
     *          [5, 9]: The substring is "baaab" which is a palindrome.
     * @Example
     *          Input: s = "abdcaaa", queries[][] = [[0, 1], [2, 2], [4, 6]]
     *          Output: [0, 1, 1]
     *          Explanation: Lets process all the queries one by one:
     *          [0, 1]: The substring is "ab" which is not a palindrome.
     *          [2, 2]: The substring is "d" which is a palindrome.
     *          [4, 6]: The substring is "aaa" which is a palindrome.
     */
    public static void main(String args[]) {
        int queries[][] = { { 0, 10 }, { 5, 8 }, { 2, 5 }, { 5, 9 } };
        System.out.println(palQueriesRabinKarp("abaaabaaaba", queries));
        System.out.println(palQueriesManachers("abaaabaaaba", queries));

    }

    /**
     * Using manacher's algorithm
     * Time complexity O(n+q)
     * Space Complexity O(n)
     * 
     */

    public static ArrayList<Integer> palQueriesManachers(String s, int[][] queries) {
        int n = s.length();
        ArrayList<Integer> list = new ArrayList<>();
        int[] p = calculatePalindrome(s);

        for (int[] query : queries) {
            if (isPalindrome(p, query[0], query[1])) {
                list.add(1);
            } else {
                list.add(0);
            }
        }

        return list;

    }

    public static int[] calculatePalindrome(String s) {
        int center = 0, right = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("@");
        for (char c : s.toCharArray()) {
            sb.append("#");
            sb.append(c);
        }
        sb.append("#$");
        s = sb.toString();
        int n = s.length();
        int p[] = new int[n];
        for (int i = 1; i < s.length() - 1; i++) {
            int mirrorIdx = center * 2 - i;
            if (i <= right) {
                p[i] = Math.min(right - i, p[mirrorIdx]);
            }
            while (s.charAt(i + p[i] + 1) == s.charAt(i - p[i] - 1)) {
                p[i]++;
            }
            if (i + p[i] > right) {
                right = i + p[i];
                center = i;
            }
        }
        return p;

    }

    public static boolean isPalindrome(int[] p, int leftIdx, int rightIdx) {
        int mid = rightIdx + leftIdx + 2;
        int len = rightIdx - leftIdx + 1;
        return p[mid] >= len;
    }

    /**
     * Using Rabin Karp algorithm
     * time complexity O(n+q)
     * space complexity O(n)
     */

    static int b1 = 31, b2 = 37;
    static int q = 1_000_000_007;

    public static ArrayList<Integer> palQueriesRabinKarp(String s, int[][] queries) {
        int n = s.length();
        ArrayList<Integer> list = new ArrayList<>();
        String revS = new StringBuilder(s).reverse().toString();
        int hash[][] = new int[n + 1][2];
        int hashR[][] = new int[n + 1][2];
        int power[][] = new int[n + 1][2];
        int powerR[][] = new int[n + 1][2];
        computeHash(s, hash, power);
        computeHash(revS, hashR, powerR);
        for (int[] arr : queries) {
            int rolledHash[] = getRolledHash(s, arr[0], arr[1], hash, power);
            int revStart = n - arr[1] - 1;
            int revEnd = n - arr[0] - 1;
            int rolledRevHash[] = getRolledHash(revS, revStart, revEnd, hashR, powerR);
            if (rolledHash[0] == rolledRevHash[0] && rolledHash[1] == rolledRevHash[1]) {
                list.add(1);
            } else {
                list.add(0);
            }
        }
        return list;

    }

    public static void computeHash(String s, int[][] hash, int[][] power) {
        power[0][0] = power[0][1] = 1;
        for (int i = 0; i < s.length(); i++) {
            hash[i + 1][0] = (int) (((long) 1l * hash[i][0] * b1 + s.charAt(i)) % q);
            hash[i + 1][1] = (int) (((long) 1l * hash[i][1] * b2 + s.charAt(i)) % q);
            power[i + 1][0] = (int) ((1l * power[i][0] * b1) % q);
            power[i + 1][1] = (int) ((1l * power[i][1] * b2) % q);
        }
    }

    public static int[] getRolledHash(String s, int start, int end, int[][] hash, int power[][]) {
        int arr[] = new int[2];
        for (int i = 0; i < 2; i++) {
            arr[i] = (int) (hash[end + 1][i] -
                    (int) (1l * hash[start][i] * power[end - start + 1][i] % q) + q)
                    % q;
        }
        return arr;
    }
}
