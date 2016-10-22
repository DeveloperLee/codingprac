package palindrome;

/**
 * Created by EricLee on 10/20/16.
 */
public class ValidPalindrome {

    public static void main(String[] args) {
        isPalindrome("A man, a plan, a canal: Panama");
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int lo = 0;
        int hi = s.length() - 1;
        while (lo <= hi) {
            while (lo <= hi && !Character.isLetterOrDigit(s.charAt(lo))) lo++;
            while (lo <= hi && !Character.isLetterOrDigit(s.charAt(hi))) hi--;
            if (lo > hi) break;
            if (!match(s.charAt(lo), s.charAt(hi))) return false;
            lo++;
            hi--;
        }
        return true;
    }

    public static boolean match(char a, char c) {
        if (a == c) return true;
        if (Character.isLetter(a) && Character.isLetter(c) &&  Math.abs(a - c) == 32) return true;
        if (Character.isDigit(a) && Character.isDigit(c)) return true;
        return false;
    }
}
