package Strings;

/**
 * @Problem Given a string s consisting of distinct lowercase characters,
 *          determine its rank among all its permutations when those are
 *          arranged in lexicographically sorted order.
 * 
 *          Note: The rank of a string is its position (starting from 1) in the
 *          sorted list of all its permutations.
 * @Example Input: s = "abc"
 *          Output: 1
 *          Explanation: All permutations of "abc" arranged in lexicographical
 *          order are: [abc, acb, bac, bca, cab, cba]. Since "abc" appears first
 *          in this list, its rank is 1.
 * 
 *          Input: s = "cba"
 *          Output: 6
 *          Explanation: All permutations of "cba" arranged in lexicographical
 *          order are: [abc, acb, bac, bca, cab, cba]. Since "cba" appears at
 *          the 6th position in this list, its rank is 6.
 * 
 *          Input: s = "string"
 *          Output: 598
 *          Explanation: If all permutations of "string" are arranged in
 *          lexicographical order, then "string" appears at the 598th position
 *          in the list. Therefore, its rank is 598.
 */
public class RankingPermutation {
    public static void main(String[] args) {
        System.out.println(findRank("string"));
    }

    public static long findRank(String s) {

        int n = s.length();

        int[] count = new int[26];

        long rank = 1;

        long fact = getFactorial(n);

        for (char c : s.toCharArray())
            count[c - 'a']++;

        for (int i = 1; i < 26; i++)
            count[i] += count[i - 1];

        for (int i = 0; i < n; i++) {

            fact /= (n - i);

            int idx = s.charAt(i) - 'a';

            int smaller = (idx == 0)
                    ? 0
                    : count[idx - 1];

            rank += smaller * fact;

            for (int j = idx; j < 26; j++)
                count[j]--;
        }

        return rank;
    }

    public static long getFactorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }
}
