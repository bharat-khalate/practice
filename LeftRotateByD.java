import java.util.*;
import java.util.stream.*;

public class LeftRotateByD {

    public static void main(String args[]) {

        int arr[] = new int[] { 1, 2, 3 };
        int d = 4;
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        while (d > 0) {
            arrList.add(arrList.remove(0));
            d--;
        }

        arr = arrList.stream().peek(System.out::println).mapToInt(Integer::intValue).toArray();

    }

}
