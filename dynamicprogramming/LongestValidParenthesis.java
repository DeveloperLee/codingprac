package dynamicprogramming;

/**
 * Created by EricLee on 10/16/16.
 * The basic idea is that we store the maximum length of valid parenthesis until the CURRENT position.
 * Apparently, if the current position is '(', the maximum length should be 0 since a sequence that
 * ends with a '(' will never be a valid sequence.
 * Then we look at the positions that ends with ')' and there are two conditions.
 * 1. The previous character (if exists) is a '(' which means that the current ')' constructs a new valid
 * sequence of length 2 '()' and the length should be 2 + the maximum length that ends at 2 characters
 * before the current one.
 * 2. The previous character (if exists) is a ')' and there's a '(' exists somewhere ahead of the current ')'
 * that can possibly construct a valid sequence. For instance '((......))'.
 * Therefore, if such '(' exists in the previous characters then the length should equals 2 + dp[i - 1] + dp[i - dp[i] - 2]
 * otherwise, the length is 0 since we can't construct a valid sequence where ends at the current position.
 */
public class LongestValidParenthesis {

    // O(n) Time since we're doing a linear search
    // O(n) Space for the dp array

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ')') {
                if (i - 1 >= 0 && s.charAt(i - 1) == '(') {
                    dp[i + 1] = dp[i - 1] + 2;
                } else if (i - dp[i] - 1 >= 0 && s.charAt(i - dp[i] - 1) == '(') {
                    dp[i + 1] = dp[i] + 2 + dp[i - dp[i] - 1];
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
