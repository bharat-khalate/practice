import java.util.*;

public class TrappingRainWater {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(3, 0, 2, 0, 4));
        int left = 0, right = numList.size() - 1, leftMax = 0, rightMax = 0, total = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, numList.get(left));
            rightMax = Math.max(numList.get(right), rightMax);

            if (leftMax < rightMax) {
                total += (leftMax - numList.get(left));
                left++;
            } else {
                total += (rightMax - numList.get(right));
                right--;
            }
        }
        System.out.println(total);
    }
}
