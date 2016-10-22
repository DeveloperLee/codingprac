package dynamicprogramming;

/**
 * Created by EricLee on 10/21/16.
 */
public class LongestIncreasingSubsequence {

    // O(N2) Time O(N) Space
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int globalMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            globalMax = Math.max(globalMax, max);
            dp[i] = max;
        }
        return globalMax;
    }
}
