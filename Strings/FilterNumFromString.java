package Strings;

import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterNumFromString {

    public static void main(String[] args) {
        List<String> strList = new ArrayList<>(List.of("Bk", "Bharat45", "Khalate99"));
        strList = strList.stream().map(str -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57)
                    continue;
                sb.append(str.charAt(i));
            }
            return String.valueOf(sb);
        }).peek(System.out::println).toList();
    }
}