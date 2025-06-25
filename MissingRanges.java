import java.util.*;
import java.util.stream.*;

public class MissingRanges {
    public static void main(String args[]) {
        int arr[] = new int[] { -48, -10, -6, -4, 0, 4, 17 };
        int lower = -54;
        int upper = 17;
        List<Integer> numList = Stream.iterate(lower, i -> i + 1).limit(upper - lower + 1)
                .collect(Collectors.toList());

        int i = lower;
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> tempList = new ArrayList<>();

        while (i <= upper) {
            if (i == lower && !arrList.contains(lower))
                tempList.add(lower);
            if (arrList.contains(i + 1)) {
                tempList.add(i);
                i++;
                while (i <= upper && arrList.contains(i)) {
                    i++;
                }
                tempList.add(i);
            }
            i++;
        }
        if (!arrList.contains(upper))
            tempList.add(upper);
        tempList.stream().forEach(System.out::println);
    }
}
