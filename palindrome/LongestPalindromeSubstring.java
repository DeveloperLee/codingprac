package palindrome;

/**
 * Created by EricLee on 10/15/16.
 */
public class LongestPalindromeSubstring {

    // A faster version that only maintains the starting index and
    // the maximum length during the scan. ~~ 19ms
    public String longestPalindromeV2(String s) {
        if (s == null || s.length() == 0) return "";
        int index = 0;
        int startIndex = -1;
        int maxLength = 0;
        while (index < s.length()) {
            int oddMaxLength = getMaximumExpandLength(s, index, true);
            int evenMaxLength = getMaximumExpandLength(s, index, false);
            if (maxLength < Math.max(oddMaxLength, evenMaxLength)) {
                if (oddMaxLength > evenMaxLength) {
                    startIndex = index - oddMaxLength / 2;
                } else {
                    startIndex = index - evenMaxLength / 2 + 1;
                }
                maxLength = Math.max(oddMaxLength, evenMaxLength);
            }
            index++;
        }
        return  s.substring(startIndex, startIndex + maxLength);
    }

    public int getMaximumExpandLength(String s, int centerIndex, boolean isOddLength) {
        int head = centerIndex;
        int tail = isOddLength ? centerIndex : centerIndex + 1;
        while (head >= 0 && tail < s.length() && s.charAt(head) == s.charAt(tail)) {
            head--;
            tail++;
        }
        return tail - head;
    }


    // Lots of string concatenation involved, possibly slow ~~ 87ms
    public String longestPalindromeV1(String s) {
        if (s == null || s.length() == 0) return "";
        int index = 0;
        String result = "";
        while (index < s.length()) {
            String oddPalindrome = getPalindromeFromCenter(s, index, true);
            String evenPalindrome = getPalindromeFromCenter(s, index, false);
            if (oddPalindrome.length() > result.length() || evenPalindrome.length() > result.length()) {
                result = oddPalindrome.length() > evenPalindrome.length() ? oddPalindrome : evenPalindrome;
            }
            index++;
        }
        return result;
    }

    public String getPalindromeFromCenter(String s, int centerIndex, boolean oddLength) {
        int head = centerIndex;
        int tail = oddLength ? centerIndex : centerIndex + 1;
        while (head >= 0 && tail < s.length() && s.charAt(head) == s.charAt(tail)) {
            head--;
            tail++;
        }
        return s.substring(head + 1, tail);
    }
}
