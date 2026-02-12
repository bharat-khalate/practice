import java.util.*;

public class EqualEvenOdd {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(2, 1, 6, 4));
        int rightEvenSum = 0, rightOddSum = 0, count = 0;
        for (int i = 0; i < numList.size(); i++) {
            if (i % 2 == 0)
                rightEvenSum += numList.get(i);
            else
                rightOddSum += numList.get(i);
        }

        int leftEvenSum = 0, leftOddSum = 0;
        for (int i = 0; i < numList.size(); i++) {
            if (i % 2 == 0) {
                rightEvenSum -= numList.get(i);
            } else
                rightOddSum -= numList.get(i);
            if (rightEvenSum + leftOddSum == rightOddSum + leftEvenSum) {
                count++;
            }
            if (i % 2 == 0) {
                leftEvenSum += numList.get(i);
            } else
                leftOddSum += numList.get(i);
        }

        System.out.println(count);

    }
}
