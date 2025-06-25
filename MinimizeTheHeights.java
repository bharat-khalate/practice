import java.util.*;
import java.util.stream.*;

public class MinimizeTheHeights {
    public static void main(String args[]) {
        int arr[] = new int[] { 3, 9, 12, 16, 20 };
        int k = 3;
        int min = Arrays.stream(arr).boxed().min(Comparator.naturalOrder()).orElse(0);
        int max = Arrays.stream(arr).boxed().max(Comparator.naturalOrder()).orElse(0);
        System.out.println(max - min - (2 * k));
        arr = Arrays.stream(arr).boxed().mapToInt(Integer::intValue).toArray();
    }
}
