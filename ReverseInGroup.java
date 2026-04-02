import java.util.*;
import java.io.*;

public class ReverseInGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        var list = br.readLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        for (String s : list) {
            arr.add(Integer.parseInt(s));
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < arr.size(); i += k) {
            int start = i;
            int end = Math.min(i + k - 1, arr.size() - 1);
            while (start < end) {
                Collections.swap(arr, start++, end--);
            }
        }
        System.out.println(arr);
    }
}
