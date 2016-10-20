package dynamicprogramming;

/**
 * Created by EricLee on 10/19/16.
 */
public class CombinationSumVI {

    public int backPackVI(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
