import java.util.ArrayList;
import java.util.List;

public class MaxConsOne {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(0, 1, 0, 1, 1, 1, 1, 0, 1));
        int max = 0;
        int i = 0;
        while (i < numList.size()) {

            int temp = i;
            while (temp < numList.size() && numList.get(temp) == numList.get(i))
                i++;
            max = Math.max(max, temp - i);
            i = temp;
        }
        System.out.println(max);
    }

}
