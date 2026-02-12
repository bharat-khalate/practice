import java.util.*;

public class MissingRange {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(-48, -10, -6, -4, 0, 4, 17));
        var returnList = new ArrayList<>();
        int lower = -54, upper = 17;

        if (!numList.contains(lower))
            returnList.add(List.of(lower, numList.getFirst() - 1));
        for (int i = 1; i < numList.size(); i++) {
            if (numList.get(i) - numList.get(i - 1) != 0) {
                returnList.add(List.of(numList.get(i - 1) + 1, numList.get(i) - 1));
            }
        }
        if (!numList.contains(upper))
            returnList.add(List.of(numList.getLast(), upper));
        System.out.println(returnList);
    }
}
