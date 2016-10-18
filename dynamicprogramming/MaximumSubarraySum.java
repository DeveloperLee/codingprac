package dynamicprogramming;

/**
 * Created by EricLee on 10/17/16.
 *
 * The idea for solving this problem is to keep track of the global maximum value
 * and the maximum sum until the current position.
 */
public class MaximumSubarraySum {

    // O(n) Time O(1) Space
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSubSum = Integer.MIN_VALUE;
        int maxEndHere = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            maxEndHere = maxEndHere < 0 ? nums[i] : maxEndHere + nums[i];
            maxSubSum = Math.max(maxSubSum, maxEndHere);
        }
        return maxSubSum;
    }
}
