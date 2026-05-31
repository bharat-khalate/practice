 ;

/**
 * @Problem Given a single string s, the task is to check if it is a palindrome
 *          sentence or not.
 *          A palindrome sentence is a sequence of characters, such as word,
 *          phrase, or series of symbols that reads the same backward as forward
 *          after converting all uppercase letters to lowercase and removing all
 *          non-alphanumeric characters (including spaces and punctuation).
 * 
 * @Example
 *          Input: s = "Too hot to hoot"
 *          Output: true
 *          Explanation: If we remove all non-alphanumeric characters and
 *          convert all uppercase letters to lowercase, string s will become
 *          "toohottohoot" which is a palindrome.
 * 
 *          Input: s = "Abc 012..## 10cbA"
 *          Output: true
 *          Explanation: If we remove all non-alphanumeric characters and
 *          convert all uppercase letters to lowercase, string s will become
 *          "abc01210cba" which is a palindrome.
 * 
 *          Input: s = "ABC $. def01ASDF"
 *          Output: false
 *          Explanation: The processed string becomes "abcdef01asdf", which is
 *          not a palindrome.
 * 
 */
public class SentencePalindrome {
    public static void main(String[] args) {
        System.out.println("Too hot to hoot");
    }

    public static boolean isPalinSent(String s) {
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while (start < end) {
            if (!isValidChar(s.charAt(start))) {
                start++;
                continue;
            }
            if (!isValidChar(s.charAt(end))) {
                end--;
                continue;
            }
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else
                return false;
        }
        return true;
    }

    public static boolean isValidChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}
