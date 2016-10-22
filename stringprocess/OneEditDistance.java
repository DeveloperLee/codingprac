package stringprocess;

/**
 * Created by EricLee on 10/21/16.
 */
public class OneEditDistance {

    // O(N) Time O(1) Space
    public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;
        int minLength = Math.min(s.length(), t.length());
        for (int i = 0; i < minLength; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) return s.substring(i + 1).equals(t.substring(i + 1));
                if (s.length() > t.length()) return s.substring(i + 1).equals(t.substring(i));
                else return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return s.length() != t.length();
    }
}
