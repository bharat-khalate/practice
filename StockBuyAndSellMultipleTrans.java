import java.util.ArrayList;
import java.util.List;

public class StockBuyAndSellMultipleTrans {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(4, 2));
        int totalProfit = 0;
        for(int i=1; i<numList.size();i++){
            if(numList.get(i)>numList.get(i-1))
                totalProfit=totalProfit+(numList.get(i)-numList.get(i-1));
        }
        System.out.println(totalProfit);
    }
}
