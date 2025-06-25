import java.util.*;
import java.util.stream.*;

public class ProductOfArrayExceptSelf {
    public static void main(String args[]) {
        int arr[] = new int[] { 12, 0 };
        int newArr[] = new int[arr.length];
        if (arr.length == 2) {
            newArr[0] = arr[1];
            newArr[1] = arr[0];
            Arrays.stream(newArr).boxed().forEach(System.out::println);
            return;
        }
        final int i[] = { 0 };
        for (i[0] = 0; i[0] < arr.length; i[0] = i[0] + 1) {
            int product = Arrays.stream(arr).filter(e -> e != arr[i[0]]).reduce(1, (e, c) -> e * c);
            newArr[i[0]] = product;
        }
        Arrays.stream(newArr).boxed().forEach(System.out::println);
    }
}
