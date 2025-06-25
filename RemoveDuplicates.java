import java.util.*;
import java.util.stream.*;

public class RemoveDuplicates {
    public static void main(String args[]) {
        int arr[] = new int[] { 1, 2, 3 };
        arr = Arrays.stream(arr).boxed().distinct().peek(System.out::println).mapToInt(Integer::intValue).toArray();
    }
}
