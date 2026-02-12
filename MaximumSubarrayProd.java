import java.util.*;

public class MaximumSubarrayProd {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(-1, -3, -10, 0, 6));
        int maxP = numList.getFirst(), tempMaxP = numList.getFirst(), tempMinP = numList.getFirst();
        for (int i = 1; i < numList.size(); i++) {
            int temp = getMax(tempMaxP * numList.get(i), tempMinP * numList.get(i), numList.get(i));
            tempMinP = Math.min(tempMaxP * numList.get(i), Math.min(tempMinP * numList.get(i), numList.get(i)));
            tempMaxP = temp;
            maxP = Math.max(maxP, tempMaxP);
        }
        System.out.println(maxP);
    }

    static int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(c, b));
    }
}
