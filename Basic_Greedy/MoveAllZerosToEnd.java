import java.util.*;
import java.io.*;

public class MoveAllZerosToEnd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var list = br.readLine().split(" ");
        var numList = new ArrayList<Integer>();

        for (String str : list)
            numList.add(Integer.parseInt(str));

        int zeros = 0;
        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) != 0) {
                Collections.swap(numList, i, zeros++);
            }
        }
        System.out.println(numList);
    }
}
