import java.io.*;
import java.io.InputStreamReader;
import java.util.*;

public class ArrayLeaders {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        var numList = Arrays.stream(bf.readLine().split(" ")).map(i -> Integer.parseInt(i.trim())).toList();
        List<Integer> leadersList = new ArrayList<>();
        int currentLeader = 0;
        for (int i = numList.size() - 1; i >= 0; i--) {
            int candidate = numList.get(i);
            if (candidate > currentLeader) {
                leadersList.addFirst(candidate);
                currentLeader = candidate;
            }
        }
        System.out.println(leadersList);
    }
}
