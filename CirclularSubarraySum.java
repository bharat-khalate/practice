import java.util.*;

public class CirclularSubarraySum {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(5, -2, 3, 4));
        int maxSum = numList.getFirst(), minSum = numList.getFirst(), tempMaxSum = numList.getFirst(),
                tempMinSum = numList.getFirst(), totalSum = numList.getFirst();
        for (int i = 1; i < numList.size(); i++) {
            tempMaxSum = Math.max(tempMaxSum + numList.get(i), numList.get(i));
            maxSum = Math.max(maxSum, tempMaxSum);
            tempMinSum = Math.min(tempMinSum + numList.get(i), numList.get(i));
            minSum = Math.min(minSum, tempMinSum);
            totalSum += numList.get(i);
        }
        int circularSum = totalSum - minSum;

        if (minSum == totalSum) {
            System.out.println(maxSum);
            return;
        }
        System.out.println(Math.max(maxSum, circularSum));
    }
}
