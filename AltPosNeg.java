
import java.util.Arrays;
import java.util.List;
import java.io.*;

public class AltPosNeg {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = bf.readLine().split(" ");
        List<Integer> arr = Arrays.stream(inputArr).map(Integer::parseInt).toList();
        List<Integer> negList = arr.stream().filter(i -> i < 0).toList();
        List<Integer> posList = arr.stream().filter(i -> i >= 0).toList();
        int pi = 0;
        int ni = 0;
        int idx = 0;

        while (pi < posList.size() && ni < negList.size()) {
            arr.set(idx++, posList.get(pi++));
            arr.set(idx++, negList.get(ni++));
        }

        while (pi < posList.size()) {
            arr.set(idx++, posList.get(pi++));
        }

        while (ni < negList.size()) {
            arr.set(idx++, negList.get(ni++));
        }
    }
}
