import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
        int idx = 1;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] != arr[i - 1]) {
                arr[idx] = arr[i];
                idx++;
            }
        System.out.println(Arrays.stream(arr).boxed().limit(idx ).toList());

    }
}
