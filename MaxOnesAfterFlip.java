import java.util.*;

public class MaxOnesAfterFlip {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 0, 0, 1, 1, 0, 0, 1, 1, 1));
        int k = 2;
        int res = 0;
        int zeros = 0;
        for (int start = 0, end = 0; end < numList.size(); end++) {
            if (numList.get(end) == 0)
                zeros++;
            while (zeros > k) {
                if (numList.get(start) == 0)
                    zeros--;
                start++;
            }
            res = Math.max( end-start + 1, res);
        }
        System.out.println(res);
    }
}
