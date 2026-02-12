import java.util.*;

public class GenPErmutations {
    static List<List<Integer>> permutations = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>(List.of(1, 2, 3));
        
            getPermutation(0, numList);
        
        permutations.forEach(System.out::println);
    }

    static void getPermutation(int idx, List<Integer> numList) {
        if (idx >= numList.size()) {
            permutations.add(new ArrayList<>(numList));
            return;
        }
        for (int i = idx; i < numList.size(); i++) {
            Collections.swap(numList, idx, i);
            getPermutation(idx + 1, numList);
            Collections.swap(numList, idx, i);
        }
    }
}
