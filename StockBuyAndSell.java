import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSell {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 3,15 , 9, 11));
        int maxProfit = 0, tempMaxProfit = 0, min = Integer.MAX_VALUE;
        for (int num : numList) {
            if (num < min) {
                maxProfit = Math.max(tempMaxProfit, maxProfit);
                min = num;
                continue;
            }
            int currentProfit = num - min;
            tempMaxProfit = Math.max(tempMaxProfit, currentProfit);
        }
        maxProfit=Math.max(tempMaxProfit, maxProfit);
        System.out.println(maxProfit);
    }
}
