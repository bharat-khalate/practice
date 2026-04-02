import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSell {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 3,15 , 9, 11));
        int maxProfit = 0,  min = numList.get(0);
        for (int num : numList) {
            min=Math.min(min,num);
            maxProfit = Math.max(maxProfit, num-min);
        }
        System.out.println(maxProfit);
    }
}
