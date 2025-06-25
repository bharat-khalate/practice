import java.util.*;
import java.util.stream.*;

public class MajorityElementII {

    public static void main(String args[]) {
        int arr[] = new int[] { 3, 2, 2, 4, 1, 4 };

        int size = (int) Math.floor(arr.length / 3);
        final int i[] = { 0 };
        List<Integer> arrList = new ArrayList<>();
        while (i[0] < arr.length) {
            int count = (int) Arrays.stream(arr).boxed().filter(e -> e == arr[i[0]]).count();
            if (count > size)
                arrList.add(arr[i[0]]);
            i[0] = i[0] + 1;
        }
        arrList = arrList.stream().distinct().peek(System.out::println).collect(Collectors.toList());
        System.out.println(arrList);

    }

}
