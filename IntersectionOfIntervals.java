import java.util.*;

public class IntersectionOfIntervals {
    public static void main(String[] args) {
        List<List<Integer>> numList1 = List.of(List.of(0, 2), List.of(5, 10), List.of(12, 22), List.of(24, 25));
        List<List<Integer>> numList2 = List.of(List.of(1, 4), List.of(9, 12), List.of(15, 24), List.of(25, 26));
        List<List<Integer>> returnList = new ArrayList<>();
        int i = 0, j = 0, n = numList1.size(), m = numList2.size();
        while (i < n && j < m) {
            int left = Math.max(numList1.get(i).get(0), numList2.get(j).get(0));
            int right = Math.min(numList1.get(i).get(1), numList2.get(j).get(1));
            if (left <= right) {
                returnList.add(List.of(left, right));
            }
            if (numList1.get(i).get(1) < numList2.get(j).get(1))
                i++;
            else
                j++;
        }
        System.out.println(returnList);
    }

}
