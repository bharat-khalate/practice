import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxTripletProduct {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(-10, -3, -5, -6, -20));
        int largest = numList.getFirst(), secondLargest = numList.getFirst(), thirdLargest = numList.getFirst(),
                smallest = numList.getFirst(), secondSmallest = numList.getFirst();
        for (int val : numList) {
            if (val > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = val;
            } else if (val > secondLargest && val < largest) {
                thirdLargest = secondLargest;
                secondLargest = val;
            } else if (val > thirdLargest && val < secondLargest) {
                thirdLargest = val;
            } else if (val < smallest) {
                secondSmallest = smallest;
                smallest = val;
            } else if (val < secondLargest && val > smallest) {
                secondSmallest = val;
            } else
                continue;
        }
        System.out.println(Math.max(smallest * secondSmallest * largest, largest * thirdLargest * secondLargest));
    }
}
