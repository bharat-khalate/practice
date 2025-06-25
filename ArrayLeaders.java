import java.util.*;
import java.util.stream.*;

public class ArrayLeaders {
    public static void main(String args[]) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 2 };
        List<Integer> leaderList = new ArrayList<>();
        int i = 0;
        while (i < arr.length) {
            int max = (int) Arrays.stream(arr).boxed().skip(i).max(Comparator.naturalOrder()).orElse(0);
            if (max == arr[i])
                leaderList.add(arr[i]);
            i++;
        }

        leaderList.stream().forEach(System.out::println);
    }
}
