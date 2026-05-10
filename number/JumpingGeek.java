package number;

/**
 * @Problem Once there was a Geek he was quite intelligent and was also fond of
 *          jumping. But he jumped in a pattern like 1 leap, 2 leap, 3 leap and
 *          again from the start after 3rd leap.
 *          1 leap means if Geek is at point P then he will jump to P+1.
 *          2 leap means if Geek is at point P then he will jump to P+2.
 *          3 leap means if Geek is at point P then he will jump to P+3.
 *          Find whether he could land up to a point N or not.
 *          Note- He starts from point 0
 * 
 * @Example Example 1:
 * 
 *          Input: N = 0
 *          Output: yes
 *          Explanation:
 *          Geek is already at Position 0.
 * 
 *          Example 2:
 *          Input: N = 1
 *          Output: yes
 *          Explanation:
 *          Geek will land at Position 1
 *          after the 1st jump.
 * 
 *          Example 3:
 *          Input: N = 8
 *          Output: no
 *          Explanation:
 *          Geek can't land at Position 8.
 */
public class JumpingGeek {
    public static void main(String args[]) {
        System.out.println(jumpingGeek(1));
    }

    static String jumpingGeek(int N) {
        int leap1 = 1;
        int leap2 = 2;
        int leap3 = 3;
        if (N % (leap1 + leap2 + leap3) == 0)
            return "yes";
        else if (N % (leap1 + leap2) == 0)
            return "yes";
        else if (N % (leap1 + leap2) == 1 && N % (leap1 + leap2 + leap3) == 1)
            return "yes";
        else
            return "no";
    }
}