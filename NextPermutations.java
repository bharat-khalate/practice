import java.util.*;
import java.util.stream.*;

class NextPermutations {
    public static void main(String args[]) {
        int arr[] = new int[] { 1, 3, 5, 4, 2 };
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int index = arr.length - 1;
        while (index > 0 && arr[index] < arr[index - 1])
            index--;
        index = (index > 0) ? index - 1 : 0;
        if (index == 0) {
            int start = 0;
            int end = arr.length - 1;
            while (start != end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
            Arrays.stream(arr).forEach(System.out::println);
            return;

        }
        arrList = arrList.stream().skip(index + 1).collect(Collectors.toList());
        Integer nextElement = arr[index];
        while (!arrList.contains(nextElement)) {
            nextElement++;
        }
        arrList.add(arr[index]);
        arrList.remove(nextElement);
        arr[index] = nextElement;

        arrList = arrList.stream().sorted().collect(Collectors.toList());
        index = index + 1;
        while (index < arr.length) {
            arr[index] = arrList.remove(0);
            index++;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
}