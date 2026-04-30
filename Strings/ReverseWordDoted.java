package Strings;

import java.util.Arrays;

public class ReverseWordDoted {

    public static String reverseWords(String s) {
        // Code here
        s = s.trim();
        String[] arr = Arrays.stream(s.split("\\.")).filter(str -> !str.isEmpty()).toList().toArray(new String[0]);
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            String temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        return String.join(".", arr);
    }

    public static void main(String args[]) {
        String str = "bharat.khalate";
        System.out.println(reverseWords(str));

    }
}
