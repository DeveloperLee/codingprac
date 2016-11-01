package stringprocess;

/**
 * Created by EricLee on 10/22/16.
 */
public class Strstr {

    public int strStrCleanVersion(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }

    // O(nk) Solution O(1) Space
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0) return 0;
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int cur = 1;
                int count = 1;
                while (cur < needle.length() && haystack.charAt(cur + i) == needle.charAt(cur)) {
                    count++;
                    cur++;
                }
                if (count == needle.length()) return i;
            }
        }
        return -1;
    }
}
