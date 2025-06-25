import java.util.*;
import java.util.stream.*;

public class MaxSubArrayProduct {
    public static void main(String args[]) {
        int arr[] = new int[] { -1, -3, -10, 0, 60 };
        int maxProduct = Arrays.stream(arr).boxed().max(Comparator.naturalOrder()).orElse(0);
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
            int product = tempList.stream().reduce(1, (i, c) -> i * c);
            maxProduct = (product > maxProduct) ? product : maxProduct;
        }
        System.out.println(maxProduct);
    }

}
