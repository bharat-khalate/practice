import java.util.*;
import java.util.stream.*;

public class AddOne {

    public static void main(String args[]) {
        int arr[] = new int[] { 0, 0, 0 };
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int total = 0;
        int factor = 1;

        while (arrList.size() != 0) {
            total = total + (arrList.removeLast() * factor);
            factor = factor * 10;
        }
        System.out.println(total + 1);

    }

}
