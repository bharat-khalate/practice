import java.util.*;

public class SmallestValueAbsentSum {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 1, 3, 4));
        int res = numList.getFirst();
        Collections.sort(numList);
        for (int i = 0; i < numList.size() && numList.get(i) <= res; i++) {
            res += numList.get(i);
        }
        System.out.println(res);
    }
}
