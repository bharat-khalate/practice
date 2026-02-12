import java.util.ArrayList;
import java.util.*;

public class ReverseArray {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1, 4, 3, 2, 6, 5));
        int start = 0, end = numList.size()-1;
        while (start < end) {
            Collections.swap(numList, start++, end--);
        }
        System.out.println(numList);
    }
}
