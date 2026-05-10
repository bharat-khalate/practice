package Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @Problem Given a string str of length N which consists of only 0, 1 or 2s,
 *          count the number of substring which have equal number of 0s, 1s and
 *          2s.
 * 
 * @Example Input: str = “0102010”
 *          Output: 2
 *          Explanation: Substring str[2, 4] = “102” and
 *          substring str[4, 6] = “201” has equal number
 *          of 0, 1 and 2
 * 
 *          Input: str = “11100022”
 *          Output: 0
 *          Explanation: There is no substring with
 *          equal number of 0 , 1 and 2.
 */
public class EqualZeroOneTwo {

    public static void main(String[] args) {
        System.out.println(getSubstringWithEqual012("11100022"));
    }

    static long getSubstringWithEqual012(String str) {
        // code here
        int z = 0, o = 0, t = 0;
        Map<String, Integer> freqMap = new HashMap<>();
        int cnt = 0;
        freqMap.put("0,0", 1);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '0')
                z++;
            if (c == '1')
                o++;
            if (c == '2')
                t++;
            String temp = (z - o) + "," + (z - t);
            cnt += freqMap.getOrDefault(temp, 0);
            freqMap.put(temp, freqMap.getOrDefault(temp, 0) + 1);
        }
        return cnt;
    }
}