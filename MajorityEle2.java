import java.util.*;

public class MajorityEle2 {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(2, 2, 3, 1, 3, 2, 1, 1));
        int candidate1 = -1, candidate2 = -1, count1 = 0, count2 = 0;
        for (int val : numList) {
            if (val == candidate1) {
                count1++;
            } else if (val == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = val;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = val;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int val : numList) {
            if (val == candidate1)
                count1++;
            if (val == candidate2)
                count2++;
        }
        var returnList = new ArrayList<Integer>();
        if (count1 >= numList.size() / 3)
            returnList.add(candidate1);
        if (count2 >= numList.size() / 3)
            returnList.add(candidate2);
        System.out.println(returnList);
    }
}
