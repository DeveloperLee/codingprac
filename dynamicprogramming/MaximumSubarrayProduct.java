package dynamicprogramming;

/**
 * Created by EricLee on 10/17/16.
 *
 * This problem is similar to maximum sum sub arry. The difference is that the maximum value
 * can be obtained from min[i - 1] * nums[i] or max[i - 1] * nums[i] because by multiplying
 * two negative values, we could possibly get a maximum value so far. Therefore, instead of
 * only keep track of the maximum value than ends at the current position, we also need to
 * keep track of the minimum value the ends at the current position so we won't miss the
 * global maximum result.
 */
public class MaximumSubarrayProduct {

    // O(n) Time O(1) Space
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSubProduct = nums[0];
        int maxHere = nums[0];
        int minHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int copyMaxHere = maxHere;
            int copyMinHere = minHere;
            minHere = Math.min(nums[i], Math.min(copyMaxHere * nums[i], copyMinHere * nums[i]));
            maxHere = Math.max(nums[i], Math.max(copyMaxHere * nums[i], copyMinHere * nums[i]));
            maxSubProduct = Math.max(maxSubProduct, maxHere);
        }
        return maxSubProduct;
    }
}
