import java.util.*;
import java.util.stream.*;

public class WaveArray {

    public static void main(String a[]) {
        int arr[] = new int[] { 10, 5, 6, 3, 2, 20, 4 };
        List<Integer> arrList = Arrays.stream(arr).boxed().sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        List<Integer> numList = new ArrayList<>();
        int num = (arrList.size() % 2 == 0) ? arrList.size() / 2 + 1 : arrList.size() / 2 + 1;

        while (arrList.size() != 0) {
            numList.add(arrList.remove(num - 1));
            if (arrList.size() != 0)
                numList.add(arrList.remove(0));
            num--;
        }

        numList.stream().forEach(System.out::println);
        // System.out.println(arrList.size());

    }

}
