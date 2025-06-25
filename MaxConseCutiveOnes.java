import java.util.*;
import java.util.stream.*;

public class MaxConseCutiveOnes {
    public static void main(String args[]) {
        int[] arr = new int[] { 0, 0, 0, 0 };
        int max = 0;

        while (true) {
            int current = arr[0];
            int i = 0;
            while (i < arr.length && arr[i] == current) {
                i++;
            }
            arr = Arrays.stream(arr).boxed().skip(i).mapToInt(Integer::intValue).toArray();
            max = (i > max) ? i : max;
            if (arr.length == 0)
                break;
        }
        System.out.println(max);
    }
}
