import java.util.*;

public class MajorityEle {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(2, 13));
        int count = 0, candidate = -1;
        for (int val : numList) {
            if (count == 0) {
                candidate = val;
                count = 1;
            } else if (val == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int val : numList) {
            if (val == candidate)
                count++;
        }
        System.out.println(count > (numList.size() / 2) ? candidate : -1);

    }
}
