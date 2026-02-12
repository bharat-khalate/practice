import java.util.*;

public class SplitInThree {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, -1, 1, -1, 1, -1, 1, -1));
        var returnList = new ArrayList<Integer>();
        int sum = numList.stream().reduce(0, Integer::sum);
        int boundary = sum / 3;
        if (boundary * 3 != sum) {
            System.out.println(List.of(-1, -1));
            return;
        }
        sum = 0;
        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
            if (sum == boundary) {
                returnList.add(i);
                sum=0;
                if (returnList.size() == 2)
                    break;
            }
        }
        System.out.println(returnList);
    }
}
