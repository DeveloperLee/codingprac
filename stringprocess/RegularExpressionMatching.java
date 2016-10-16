package stringprocess;

/**
 * Created by EricLee on 10/15/16.
 */
public class RegularExpressionMatching {

    // Recursive solution for regular expression matching problem
    public boolean isMatchRecursive(String s, String p) {
        if (s == null || p == null) return false;
        if (p.length() == 0) return s.length() == 0;
        if (p.length() == 1) {
            if (s.length() != 1) return false;
            return (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
        }

        // The length of pattern is at least 2 from here
        if (s.length() != 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
            if (p.charAt(1) == '*') {
                return isMatchRecursive(s, p.substring(2)) || isMatchRecursive(s.substring(1), p);
            }
            return isMatchRecursive(s.substring(1), p.substring(1));
        }

        // If the first letter between s and pattern doesn't match, the only possibility
        // that s and p eventually matches is that pattern contains a * in the second
        // position and represents 0 length.
        return (p.charAt(1) == '*' && isMatchRecursive(s, p.substring(2)));
    }

    // DP solution for regular expression matching problem
//    public boolean isMatchDP(String s, String p) {
//
//    }
}
