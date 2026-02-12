import java.util.*;

public class ApplyEQNAndSortArr {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(-1, 0, 1, 2, 3, 4));
        int a = -1, b = 2, c = -1;
        System.out.println(numList.stream().map(i -> a * (i * i) + (b * i) + c).sorted().toList());
    }
}
