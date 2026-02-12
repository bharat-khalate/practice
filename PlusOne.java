import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(9, 9,9, 8));
        int sum = 0;
        for(int num:numList)
            sum=sum*10+num;
        System.out.println(sum+1);
    }
}
