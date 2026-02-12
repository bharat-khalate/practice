import java.util.*;

public class SmallestMissingPos {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(2, -3, 4, 1, 1, 7));
        boolean flag = false;
        int n = numList.size();

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) == 1) {
                flag = true;
            }
        }
        if (!flag) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) <= 0 || numList.get(i) > n)
                numList.set(i, 1);           
        }


          for (int i = 0; i < numList.size(); i++) {
            int val = numList.get(i);
            int idx = (val - 1) % n;
            numList.set(idx, numList.get(idx) + n);
            
        }

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) <= n) {
                System.out.println(i + 1);
                return;
            }
        }

        System.out.println(n + 1);

    }
}
