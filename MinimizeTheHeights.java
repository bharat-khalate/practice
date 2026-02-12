import java.util.*;

class MinimizeTheHeights {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(3, 9, 12, 16, 20));
        Collections.sort(numList);
        int k = 3;
        int maxH = numList.getLast() - numList.getFirst();
        for (int i = 1; i < numList.size(); i++) {
            if (numList.get(i) - k < 0)
                continue;
            int tempMaxH = Math.max(numList.getLast() - k, numList.get(i - 1) + k);
            int tempMinH = Math.min(numList.getFirst() + k, numList.get(i) - k);
            maxH = Math.min(maxH, tempMaxH - tempMinH);
        }
        System.out.println(maxH);
    }
}