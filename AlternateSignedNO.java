import java.util.*;
import java.util.stream.*;

public class AlternateSignedNO {
    public static void main(String args[]) {
        int arr[] = new int[] { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
        List<Integer> negativeList = Arrays.stream(arr).boxed().filter(i -> i < 0).collect(Collectors.toList());
        List<Integer> positiveList = Arrays.stream(arr).boxed().filter(i -> i >= 0).collect(Collectors.toList());
        List<Integer> tempList = new ArrayList<>();

        while (negativeList.size() != 0 || positiveList.size() != 0) {
            if (positiveList.size() != 0)
                tempList.add(positiveList.remove(0));
            if (negativeList.size() != 0)
                tempList.add(negativeList.remove(0));
        }
        arr = tempList.stream().peek(System.out::println).mapToInt(Integer::intValue).toArray();

    }

}
