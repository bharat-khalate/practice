import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSellMultipleTrans {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(4, 2));
        int totalProfit = 0, tempMaxProfit = 0, min = Integer.MAX_VALUE;
        for (int price : numList) {
            if (price < min) {
                totalProfit += tempMaxProfit;
                tempMaxProfit=0;
                min = price;
                continue;
            }
            int currentProfit=price-min;
            tempMaxProfit=Math.max(tempMaxProfit, currentProfit);
        }
        totalProfit+=tempMaxProfit;
        System.out.println(totalProfit);
    }
}
