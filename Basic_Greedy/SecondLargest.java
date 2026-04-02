
import java.util.*;

class SecondLargest {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(12, 35, 1, 10, 34, 1));
        int largest = 0, secondLargest = 0;
        for (int val : numList)
            if (val > largest) {
                secondLargest = largest;
                largest = val;
            } else if (val > secondLargest)
                secondLargest = val;
        System.out.println(secondLargest);
    }
}