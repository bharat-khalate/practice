import java.io.*;
import java.util.*;

public class AntAndPlanks {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the plank size and left directed ants and right directed ants");
        int n = Integer.parseInt(bf.readLine());
        var left = new ArrayList<Integer>();
        var right = new ArrayList<Integer>();
        for (String str : bf.readLine().split(" ")) {
            left.add(Integer.parseInt(str));
        }
        for (String str : bf.readLine().split(" ")) {
            right.add(Integer.parseInt(str));
        }
        int res = left.stream().max(Comparator.naturalOrder()).orElse(0);
        for (int pos : right) {
            res = Math.max(n - pos, res);
        }
        
        System.out.println(res);
        // int n = 4;
        // var left = new ArrayList<Integer>(List.of());
        // var right = new ArrayList<Integer>(List.of(0, 1, 2, 3, 4));
        // int res = left.stream().max(Comparator.naturalOrder()).orElse(0);
        // for(int val:right)
        // res=Math.max(n-val, res);
        // System.out.println(res);
    }
}