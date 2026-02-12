import java.util.*;

public class SubarrayProdLessThanK {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(10, 5, 2, 6));
        int k = 100;
        int p = 1, count = 0;
        for (int start = 0, end = 0; end < numList.size(); end++) {
            p *= numList.get(end);
            while (start < end && p >= k) {
                p /= numList.get(start);
                start++;
            }
            if (p < k)
                count += end - start + 1;
        }
        System.out.println(count);
    }
}
