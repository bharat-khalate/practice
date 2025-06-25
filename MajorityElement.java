import java.util.*;
import java.util.stream.*;

public class MajorityElement {

    public static void main(String args[]) {

        int[] arr = new int[] { 1, 1, 2, 1, 3, 5, 1 };
        final int i[] = { 0 };
        int ele = -1;
        int length = arr.length / 2;
        while (i[0] < arr.length) {
            int count = (int) Arrays.stream(arr).boxed().filter(e -> e == arr[i[0]]).count();
            if (count > length) {
                ele = arr[i[0]];
                break;
            }
            i[0] = i[0] + 1;
        }
        System.out.println(ele);
    }

}
