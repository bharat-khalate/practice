import java.util.*;

public class WaveArray {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>(List.of(2, 4, 7, 8, 9, 10));
        for (int i = 0; i < numList.size() - 1; i += 2) {
            Collections.swap(numList, i + 1, i);
        }
        System.out.println(numList);
    }
}
