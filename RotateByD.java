import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotateByD {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int d = 2;
        d = d % numList.size();
        reverseList(numList, 0, d - 1);
        reverseList(numList, d, numList.size() - 1);
        reverseList(numList, 0, numList.size() - 1);
        System.out.println(numList);

    }

    public static void reverseList(List<Integer> numList, int start, int end) {
        while (start < end) {
            Collections.swap(numList, start, end);
            start++;
            end--;
        }
    }
}
