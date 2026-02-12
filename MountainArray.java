import java.util.*;

public class MountainArray {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(1,2,1,2));
        int i = 1;
        int count = 0;
        while (i < numList.size()) {
            int j = i;
            while (j<numList.size() && numList.get(j) > numList.get(j - 1))
                j++;

            while (j<numList.size() && numList.get(j) < numList.get(j - 1))
                j++;
            count = Math.max(count, j - i);
            i=j;
        }
        System.out.println(count);
    }
}
