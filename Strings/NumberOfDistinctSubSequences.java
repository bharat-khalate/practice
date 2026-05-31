import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Problem Given a string str consisting of lowercase english alphabets, the
 *          task is to find the number of distinct subsequences of the string
 *          Note: Answer can be very large, so, ouput will be answer modulo
 *          109+7.
 * @Example Input: str = "gfg"
 *          Output: 7
 *          Explanation:
 *          The seven distinct subsequences are "", "g", "f", "gf", "fg", "gg"
 *          and "gfg" .
 * 
 *          Input: str = "ggg"
 *          Output: 4
 *          Explanation:
 *          The four distinct subsequences are "", "g", "gg", "ggg".
 */
public class NumberOfDistinctSubSequences {

    public static void main(String args[]) {
        System.out.println(distinctSubseqRecurse("gfg"));
        System.out.println(distinctSubseqDpBottomUp("gfg"));
        System.out.println(distinctSubseqDpSpaceOptimized("gfg"));
    }

    /**
     * Using recursion + backtracking
     * Time Complexity O(2^n)
     * Space Complexity O(2^n)
     */
    static Set<String> set = new HashSet<>();

    static int distinctSubseqRecurse(String str) {
        recurse(str, 0, new StringBuilder());
        return set.size();
    }

    public static void recurse(String str, int i, StringBuilder sb) {
        if (i >= str.length()) {
            set.add(sb.toString());
            return;
        }
        recurse(str, i + 1, sb);
        sb.append(str.charAt(i));
        recurse(str, i + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    /**
     * using DP Bottom UP approach
     * time complexity O(n)
     * space complexity O(n)
     */
    static int distinctSubseqDpBottomUp(String str) {
        int dp[] = new int[str.length() + 1];
        int mod = 1000000007;
        dp[0] = 1;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 1; i <= str.length(); i++) {
            dp[i] = (int) (1l * 2 * dp[i - 1]) % mod;
            int idx = str.charAt(i - 1) - 'a';
            if (last[idx] != -1) {
                dp[i] = (int) (1l * dp[i] - dp[last[idx]] + mod) % mod;
            }

            last[idx] = i - 1;
        }
        return dp[str.length()];
    }

    /**
     * DP SPace Optimization technic
     * Time Complexity O(n)
     * Space Complexity O(1)
     */
    static int distinctSubseqDpSpaceOptimized(String str) {
        int mod = 1000000007;
        int ans = 1;
        int[] last = new int[26];
        for (int i = 1; i <= str.length(); i++) {
            int idx = str.charAt(i - 1) - 'a';
            int temp = ans;
            ans = (int) (((1l * 2 * ans) % mod - last[idx] + mod) % mod);
            last[idx] = temp;
        }
        return ans;
    }

}
