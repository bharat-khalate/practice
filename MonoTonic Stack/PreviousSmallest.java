import java.util.*;

public class PreviousSmallest {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 2, 10, 8 };
        int res[] = new int[arr.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = arr.length - 1; i >=0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        for (int num : res)
            System.out.print(num);
    }
}
