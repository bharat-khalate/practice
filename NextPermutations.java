import java.util.*;

public class NextPermuTations {
    public static void main(String[] args) {
        var numList = new ArrayList<Integer>(List.of(1, 3, 5, 4, 2));
        int i = numList.size() - 2;
        int pivot = -1;
        for (i = numList.size() - 2; i >= 0; i--) {
            if (numList.get(i) < numList.get(i + 1)) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            reverseArray(numList, 0, numList.size() - 1);
            System.out.println(numList);
            return;
        }
      
        for (i = numList.size() - 1; i > pivot; i--) {
            if (numList.get(i) > numList.get(pivot))
                break;
        }
        Collections.swap(numList, pivot, i);
        reverseArray(numList, pivot+1, numList.size() - 1);
        System.out.println(numList);

    }

    public static void reverseArray(List<Integer> numList, int start, int end) {
        while (start < end) {
            Collections.swap(numList, start, end);
            start++;
            end--;
        }
    }
}
