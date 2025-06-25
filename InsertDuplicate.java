import java.util.*;
import java.util.stream.*;

public class InsertDuplicate {
    public static void main(String args[]) {
        int arr[] = new int[] { 7, 5, 8 };
        int k = 8;
        List<Integer> arrList = new ArrayList<>();
        int i = 0;

        while (i < arr.length) {
            if (arr[i] == k && i < arr.length - 1 && arr[i + 1] != k) {
                arrList.add(k);
            }
            arrList.add(arr[i]);
            i++;
        }
        arr = arrList.stream().limit(arr.length).peek(System.out::println).mapToInt(Integer::intValue).toArray();

    }

}
