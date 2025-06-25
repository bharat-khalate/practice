import java.util.*;
import java.util.stream.*;

public class ReverseByGroup {

    public static void main(String args[]) {
        int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        int k = 10;
        List<List<Integer>> numList = new ArrayList<>();
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        while (true) {
            int i = (k < arrList.size()) ? k : arrList.size();
            List<Integer> tempList = new ArrayList<>();
            while (i > 0) {
                tempList.add(0, arrList.remove(0));
                i--;
            }
            numList.add(tempList);
            if (arrList.size() == 0)
                break;
        }

        numList.stream().flatMap(Collection::stream).forEach(System.out::println);
    }

}
