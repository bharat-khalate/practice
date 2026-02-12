import java.util.ArrayList;
import java.util.List;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(5, 4, 1, 7, 8));
        int res = numList.get(0), maxEnding = numList.get(0);
        numList.removeFirst();
        for (int val : numList) {
            maxEnding = Math.max(maxEnding + val, val);
            res = Math.max(maxEnding, res);
        }
        System.out.println(res);
    }
}
