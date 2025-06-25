import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class ThreeGreatCandidates {
    public static void main(String args[]) {
        int[] arr = new int[] { 1, -4, 3, -6, 7, 0 };
        arr = Arrays.stream(arr).boxed().sorted().filter(i -> i != 0).mapToInt(Integer::intValue).toArray();
        boolean ops = (arr.length > 1 && arr[1] < 0 && arr[arr.length - 1] > 0) ? true : false;
        Stream<Integer> streamList = Arrays.stream(arr).boxed();
        int greatCandidate = (ops) ? streamList.limit(2).reduce(1, (i, c) -> i * c) * arr[arr.length - 1]
                : streamList.skip(arr.length - 3).reduce(1, (i, c) -> i * c);
        System.out.println(greatCandidate);
    }

}
