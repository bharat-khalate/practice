import java.util.*;

public class MinIncrementToEqualize {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(4, 3, 4));
        int min = numList.stream().min(Comparator.naturalOrder()).orElse(0);
        int sum = numList.stream().reduce(0, Integer::sum);
        System.out.println(sum-min*numList.size());
    }
}
