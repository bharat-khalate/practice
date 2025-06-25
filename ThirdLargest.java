import java.util.*;
import java.util.stream.Collectors;

public class ThirdLargest {
    public static void main(String args[]) {
        int[] arr = new int[] { 19, -10, 20, 14, 2, 16, 10 };
        arr = Arrays.stream(arr).boxed().distinct().sorted().mapToInt(Integer::intValue).toArray();
        System.out.println((arr.length > 2) ? arr[arr.length - 3] : (arr.length > 1) ? arr[2] : arr[0]);

    }
}
