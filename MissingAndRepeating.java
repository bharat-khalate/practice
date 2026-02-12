import java.util.*;

public class MissingAndRepeating {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(3, 1, 3));
        int n = numList.size();
        int s = (n * (n + 1)) / 2;
        int ssq = (n * (n + 1) * (2 * n + 1)) / 6;
        for(int val:numList){
            s-=val;
            ssq-=val*val;
        }
        int missing=(s+ssq/s)/2;
        int repeating=missing-s;
        System.out.println(List.of(missing, repeating));
    }
}
