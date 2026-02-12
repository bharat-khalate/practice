import java.util.*;

public class MaxProdExceptSelf {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(10, 3, 5, 6, 2));
        int maxP = numList.stream().filter(i -> i != 0).reduce(1, (a, b) -> a * b);
        boolean isZero = numList.contains(0);
        for (int i = 0; i < numList.size(); i++) {
            int val = isZero ? numList.get(i) == 0 ? maxP : 0 : maxP / numList.get(i);
            numList.set(i, val);
        }
        System.out.println(numList);
    }
}
