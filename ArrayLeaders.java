import java.util.*;

public class ArrayLeaders {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 2));
        var leadersList = new ArrayList<Integer>();
        Collections.reverse(numList);
        leadersList.add(numList.removeFirst());
        while (!numList.isEmpty()) {
            int cur = numList.removeFirst();
            if (leadersList.getFirst() < cur)
                leadersList.addFirst(cur);
        }
        System.out.println(leadersList);
    }
}
