import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AntAndPlanks {
    public static void main(String args[]) {
        int n = 4;
        var left = new ArrayList<Integer>(List.of());
        var right = new ArrayList<Integer>(List.of(0, 1, 2, 3, 4));
        int res = left.stream().max(Comparator.naturalOrder()).orElse(0);
        for(int val:right)
            res=Math.max(n-val, res);
        System.out.println(res);
    }
}