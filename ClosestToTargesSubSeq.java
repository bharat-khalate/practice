import java.util.*;

public class ClosestToTargesSubSeq {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 2, 3));
        int target = -7;
        int size = numList.size();
        List<Integer> lefttList = new ArrayList<Integer>();
        List<Integer> rightList = new ArrayList<Integer>();
        genSubSequence(numList, 0, size / 2, lefttList);
        genSubSequence(numList, size / 2, size , rightList);
        Collections.sort(rightList);
        int minDiff = Math.abs(target);

        for (int val : lefttList) {
            int remaining = target - val;
            int pos = Collections.binarySearch(rightList, remaining);
            if (pos >= 0) {
                System.out.println(0);
                return;
            } else{
                pos = -pos - 1;
            }

            if (pos < rightList.size()) {
                minDiff = Math.min(minDiff, Math.abs(remaining - rightList.get(pos)));
            }
            if (pos > 0) {
                minDiff = Math.min(minDiff, Math.abs(remaining - rightList.get(pos - 1)));

            }
        }
        System.out.println(minDiff);
    }

    public static void genSubSequence(List<Integer> numList, int start, int end, List<Integer> sumList) {
        int n = end - start;
        for (int mask = 0; mask < (1 << n); ++mask) {
            int sum = 0;
            for (int i = 0; i < n; ++i) {
                if ((mask & (1 << i)) != 0)
                    sum += numList.get( start+i);
            }
            sumList.add(sum);
        }
    }
}
