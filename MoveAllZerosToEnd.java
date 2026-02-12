import java.util.*;

public class MoveAllZerosToEnd {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(0,1,1,0,0,0,9,1,1, 0));
        int count = 0;
        for (int i = 0; i < numList.size(); i++)
            if (numList.get(i) != 0) {
                Collections.swap(numList, i, count);
                count++;
            }
        System.out.println(numList);
    }
}
