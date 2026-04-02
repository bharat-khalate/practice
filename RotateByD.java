import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;

public class RotateByD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());
        var list = br.readLine().split(" ");
        var numList = new ArrayList<Integer>();
        for (String str : list)
            numList.add(Integer.parseInt(str));
        if(d>numList.size()){
            reverseList(0, numList.size()-1, numList);
            System.out.println(numList);
            return;
        }
        reverseList(0, d - 1, numList);
        reverseList(d, numList.size() - 1, numList);
        reverseList(0, numList.size() - 1, numList);
        System.out.println(numList);

    }

    public static void reverseList(int start, int end, List<Integer> numList) {
        while (start < end) {
            Collections.swap(numList, start++, end--);
        }
    }
}
