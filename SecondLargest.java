import java.util.*;
import java.util.stream.Collectors;

public class SecondLargest {

    public static void main(String args[]) {
        int[] arr = new int[] { 10, 10 };
        arr = Arrays.stream(arr).boxed().sorted(Comparator.naturalOrder()).distinct().peek(System.out::println)
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println((arr.length > 1) ? arr[arr.length - 2] : arr[0]);
    }

}
