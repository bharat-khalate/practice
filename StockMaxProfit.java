import java.util.*;
import java.util.stream.*;

public class StockMaxProfit {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 3, 6, 9, 11 };
        int maxProfit = 0;
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        while (arrList.size() != 0) {
            int i = 0;
            int min = arrList.remove(0);
            int max = 0;
            while (i < arrList.size()) {
                int profit = arrList.get(i) - min;
                max = (profit > max) ? profit : max;
                i++;
            }
            maxProfit = (max > maxProfit) ? max : maxProfit;
        }
        System.out.println(maxProfit);
    }
}
