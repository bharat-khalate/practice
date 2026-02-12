import java.util.*;

public class MinSwapsToGroupOne {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 1, 0, 1, 0, 1, 1));
        int maxOnes = Math.toIntExact(numList.stream().filter(i -> i == 1).count());
        int maxOnesInWindow = 0;
        for (int i = 0; i < maxOnes; i++)
            if (numList.get(i) == 1)
                maxOnesInWindow++;
        int tempMaxOnes = maxOnesInWindow;
        for (int i = 1; i < numList.size() - maxOnes; i++) {
            if (numList.get(i - 1) == 1)
                tempMaxOnes--;
            if (numList.get(i + maxOnes) == 1)
                tempMaxOnes++;
            maxOnesInWindow = Math.min(tempMaxOnes, maxOnesInWindow);
        }
        System.out.println(maxOnes - maxOnesInWindow);
    }
}
