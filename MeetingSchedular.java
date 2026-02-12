import java.util.*;

public class MeetingSchedular {
    public static void main(String[] args) {
        List<List<Integer>> numList1 = List.of(List.of(10, 50), List.of(60, 120), List.of(140, 210));
        List<List<Integer>> numList2 = List.of(List.of(0, 22), List.of(60, 90));
        int i = 0, j = 0, n = numList1.size(), m = numList2.size();
        int d = 12;
        while (i < n && j < m) {
            int left = Math.max(numList1.get(i).get(0), numList2.get(j).get(0));
            int right = Math.min(numList1.get(i).get(1), numList2.get(j).get(1));

            if (right - left >= d) {
                System.out.println(List.of(left, left + d));
                return;
            }

            if (numList1.get(i).get(1) < numList2.get(j).get(1))
                i++;
            else
                j++;
        }
        System.out.println(List.of(-1,-1));
    }
}