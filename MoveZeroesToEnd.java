import java.util.*;
import java.util.stream.*;

public class MoveZeroesToEnd {
    public static void main(String srgs[]) {
        int[] arr = new int[] { 0, 0 };
        final int[] totalZeroes = { 0 };

        List<Integer> numList = Arrays.stream(arr).boxed().filter(i -> {
            if (i == 0) {
                totalZeroes[0] = totalZeroes[0] + 1;
            }
            return i != 0;
        }).collect(Collectors.toList());

        Stream.iterate(0, i -> i).limit(totalZeroes[0]).forEach(i -> {
            numList.add(0);
        });

        arr = numList.stream().peek(System.out::println).mapToInt(Integer::intValue).toArray();
    }
}
