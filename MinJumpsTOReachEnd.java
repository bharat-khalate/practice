import java.util.*;

public class MinJumpsTOReachEnd {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(0, 10, 20));
        if (numList.getFirst() == 0) {
            System.out.println(0);
            return;
        }
        int maxRange = 0, curReach = 0, i = 0, jumps = 0;
        for (i = 0; i < numList.size(); i++) {
            maxRange = Math.max(maxRange, i + numList.get(i));

            if (maxRange >= numList.size() - 1) {
                System.out.println(jumps + 1);
                return;
            }

            if (i == curReach) {
                if (maxRange == i) {
                    System.out.println(0);
                    return;
                } else {
                    jumps++;
                    curReach = maxRange;
                }
            }
        }
    }
}
