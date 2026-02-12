import java.util.ArrayList;

public class FarthestOne {
    public static void main(String[] args) {
        var str = "1000";
        int res = -1, zeros = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zeros++;
            } else if (str.charAt(i) == '1' && res == -1) {
                res = zeros;
                zeros = 0;
            } else {
                res = Math.max(res, (int) Math.ceil(zeros / 2.0));
                zeros=0;
            }
        }
        res = Math.max(res, zeros);
        System.out.println(res);
    }
}
