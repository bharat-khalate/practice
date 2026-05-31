 ;

/**
 * @Problem You are given a string s in the form of an IPv4 Address. Your task
 *          is to validate an IPv4 Address, if it is valid return true otherwise
 *          return false.
 * 
 *          -IPv4 addresses are canonically represented in dot-decimal notation,
 *          which consists of four decimal numbers, each ranging from 0 to 255,
 *          separated by dots, e.g., "172.16.254.1"
 * 
 *          -A valid IPv4 Address is of the form x1.x2.x3.x4 where 0 <= (x1, x2,
 *          x3, x4) <= 255. Thus, we can write the generalized form of an IPv4
 *          address as (0-255).(0-255).(0-255).(0-255)
 * 
 *          Note: Here we are considering numbers only from 0 to 255 and any
 *          additional leading zeroes will be considered invalid.
 * @Example Input: s = "222.111.111.111"
 *          Output: true
 *          Explanation: Here, the IPv4 address is as per the criteria mentioned
 *          and also all four decimal numbers lies in the mentioned range.
 * 
 *          Input: s = "5555..555"
 *          Output: false
 *          Explanation: "5555..555" is not a valid IPv4 address, as the middle
 *          two portions are missing.
 * 
 *          Input: s = "0.0.0.255"
 *          Output: true
 */
public class ValidiateIpAddress {
    public static void main(String[] args) {
        System.out.println(isValid("0.0.0.255"));
    }

    public static boolean isValid(String s) {
        // code here
        int parts = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '.')
                return false;
            int num = 0;
            int digit = 0;
            while (i < n && s.charAt(i) != '.') {
                char c = s.charAt(i);
                if (c < '0' || c > '9')
                    return false;
                num = num * 10 + (c - '0');
                digit++;
                i++;
            }
            if (digit > 1 && (s.charAt(i - digit) == '0' || num < 0 || num > 255))
                return false;
            if (i < n && s.charAt(i) == '.') {
                i++;
                if (i == n)
                    return false;
            }
            parts++;
        }
        return parts == 4;
    }
}