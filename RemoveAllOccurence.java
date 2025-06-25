import java.util.*;
import java.util.stream.*;

public class RemoveAllOccurence {

    public static void main(String args[]) {
        int[] arr = new int[] { 0, 1, 3, 0, 2, 2, 4, 2 };
        int ele = 3;

        int count = (int) Arrays.stream(arr).boxed().filter(i -> i != ele).count();
        System.out.println(count);

    }

}
