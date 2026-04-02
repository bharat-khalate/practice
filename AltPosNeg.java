import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.*;

public class AltPosNeg {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = bf.readLine().split(" ");
        var numList = Arrays.stream(inputArr).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        var negList = numList.stream().filter(i -> i < 0).collect(Collectors.toList());
        numList = new ArrayList<>(numList.stream().filter(i -> i >= 0).toList());
        int numIdx = 1;
        for (int i = 0; i < negList.size(); i++) {
            if (numIdx < numList.size()) {
                numList.add(numIdx, negList.get(i));
                numIdx += 2;
            } else {
                numList.add(negList.get(i));
            }
        }
        System.out.println(numList);
    }
}
