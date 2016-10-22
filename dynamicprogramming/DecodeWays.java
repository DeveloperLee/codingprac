package dynamicprogramming;

/**
 * Created by EricLee on 10/20/16.
 *
 * The idea is that for each new character we combine it with its previous letter to form a new number.
 * If this number is 0 (which means two consecutive 0s) or the sum is a ten-based number that is greater
 * than 26 (30, 40.....) this input is invalid since we return 0 (no way to represent this string)
 * If the new number is less than 26, it means that these two letters can be replaced by a new letter, so
 * there's two ways to represent these two letters, for example 26 -> (Z or BF) so the total number of ways
 * until here should be dp[i+1] + dp[i+2]. Otherwise, we have only 1 way to represent these two letters,
 * for example (42 can only be represented as DB) so the total ways until here is the same as the previous position.
 */
public class DecodeWays {

    // O(n) Time and O(1) Space
    public int numDecodingsWithConstantSpace(String s) {
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        int twoLettersAway = 1;
        int oneLetterAway = s.charAt(length - 1) == '0' ? 0 : 1;
        int currentWays = 0;
        for (int i = length - 2; i >= 0; i--) {
            int sum = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (sum == 0 || (sum > 20 && sum % 10 == 0)) return 0;
            if (s.charAt(i)  == '0') {
                currentWays = 0;
            } else {
                currentWays = sum <= 26 ? oneLetterAway + twoLettersAway : oneLetterAway;
            }
            twoLettersAway = oneLetterAway;
            oneLetterAway = currentWays;
        }
        return oneLetterAway;
    }

    // O(n) Time O(n) space
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[length] = 1;
        dp[length - 1] = s.charAt(length - 1) == '0' ? 0 : 1;
        for (int i = length - 2; i >= 0; i--) {
            int sum = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (sum == 0 || (sum > 20 && sum % 10 == 0)) return 0;
            if (s.charAt(i)  == '0') continue;
            dp[i] = sum <= 26 ? dp[i + 1] +dp[i + 2] : dp[i + 1];
        }
        return dp[0];
    }
}
