import java.util.ArrayList;
import java.util.List;

public class AltPosNeg {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(-5, -2, 5, 2, 4, 7, 1, 8, 0, -8));
        List<Integer> negList = numList.stream().filter(i -> i < 0).toList();
        numList = new ArrayList<Integer>(numList.stream().filter(i -> i >= 0).toList());
        int i = 1;
        for (int j = 0; j < negList.size(); j++) {
            if (i < numList.size()) {
                numList.add(i, negList.get(j));
                i += 2;
                continue;
            }
            numList.add(negList.get(j));
        }
        System.out.println(numList);
    }
}
