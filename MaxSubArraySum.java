import java.util.*;
import java.util.stream.*;

class MaxSubArraySum {
    public static void main(String args[]) {
        int arr[] = new int[] { 5, 4, 1, 7, 8 };
        int maxSum = Arrays.stream(arr).boxed().max(Comparator.naturalOrder()).orElse(0);
        List<List<Integer>> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> tempList = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                tempList.add(arr[j]);
                arrList.add(new ArrayList<>(tempList));
            }
        }

        while (!arrList.isEmpty()) {
            List<Integer> tempList = arrList.remove(0);
            int total = tempList.stream().reduce(0, (i, c) -> i + c);
            maxSum = (total > maxSum) ? total : maxSum;
        }
        System.out.println(maxSum);
    }
}