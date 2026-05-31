 ;

public class PalindromeCheck {
    public static void main(String args[]) {
        String str = "abba";
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                break;
            }
        }
        if (start >= end) {
            System.out.println(true);
            return;
        }
        System.out.println(false);
    }
}
