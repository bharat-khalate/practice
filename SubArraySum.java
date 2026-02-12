import java.util.ArrayList;
import java.util.List;

public class SubArraySum {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 2, 3, 4));
        int sum = 0;
        int n=numList.size();
        for (int i = 0; i < n; i++) {
            sum += (numList.get(i)*(n - i) *(i+1));
        }
        System.out.println(sum);
    }
}
