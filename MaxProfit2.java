import java.util.*;
import java.util.stream.*;

public class MaxProfit2 {

    public static void main(String[] ices) {

        int[] prices = { 4, 2, 2, 2, 4 };
        List<Integer> pricesList = Arrays.stream(prices).boxed().collect(Collectors.toList());

        int smallest = prices[0];
        int largest = prices[0];
        int profit = 0;
        int i = 1;
        while (i < prices.length) {
            if (prices[i] < smallest) {
                if (i >= prices.length)
                    break;
                largest = prices[i - 1];
                profit = profit + (largest - smallest);
                smallest = prices[i];

            }
            if (i == prices.length - 1 && prices[i] > smallest) {
                profit = profit + (prices[i] - smallest);
            }
            i++;
        }
        System.out.println(profit);
    }

}
