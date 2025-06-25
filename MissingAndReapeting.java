import java.util.*;
import java.util.stream.*;

public class MissingAndReapeting {

    public static void main(String args[]) {
        int arr[] = new int[] { 4, 3, 6, 2, 7, 7 };
        int i = 0;
        arr = Arrays.stream(arr).boxed().sorted().mapToInt(Integer::intValue).toArray();
        List<Integer> eleList = new ArrayList<>();
        int missing = 0;

        while (i < arr.length) {
            if (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                eleList.add(arr[i]);
            }

            if (arr[i] != i + 1) {
                missing = i + 1;
            }
            i++;
        }
        System.out.println(missing + "  \n" + eleList.get(0));
    }

}
