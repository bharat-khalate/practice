import java.util.*;

public class NextSmallestPalindrome {
    public static void main(String[] args) {
        var numList = new ArrayList<>(List.of(9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2));
        boolean isAllNine = true;
        for (int val : numList) {
            if (val != 9) {
                isAllNine = false;
                break;
            }
        }
        if (isAllNine) {
            int[] arr = new int[numList.size() + 1];
            arr[0] = 1;
            arr[numList.size()] = 1;
            Arrays.stream(arr).forEach(System.out::println);
        }

        int start = 0, end = numList.size()-1;
        var resList = new ArrayList<>(numList);
        while (start < end) {
            resList.set(end, resList.get(start));
            start++;
            end--;
        }

        boolean isSmall = false;

        for (int i = 0; i < numList.size(); i++) {
            if (numList.get(i) > resList.get(i)) {
                isSmall = true;
                break;
            } else if (numList.get(i) < resList.get(i)) {
                break;
            }
        }
        if (isSmall) {
            int carry = 1;
            int left = (resList.size() - 1) / 2;
            int right = resList.size() / 2;
            while (left >= 0 && carry > 0) {
                int sum = resList.get(left) + carry;
                resList.set(left, sum % 10);
                carry = sum / 10;
                resList.set(right, sum%10);
                left--;
                right++;
            }
        }
        System.out.println(resList);
    }
}
