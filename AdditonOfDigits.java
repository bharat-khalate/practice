import java.util.*;
import java.util.stream.*;

public class AdditonOfDigits {
    public static void main(String args[]) {
        int num = 5674;
        int sum = 0;

        while (num != 0) {
            int a = num % 10;
            sum = sum + a;
            num = num / 10;
        }
        System.out.println(sum);
    }

}
