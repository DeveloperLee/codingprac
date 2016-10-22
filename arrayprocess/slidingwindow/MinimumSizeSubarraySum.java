package arrayprocess.slidingwindow;

/**
 * Created by EricLee on 10/21/16.
 *
 * If the array only contains positive numbers, we can use a sliding window to solve it.
 * If the array contains negative numbers, we can use a O(nlogn) Solution to solve it.
 */
public class MinimumSizeSubarraySum {

    // O(nlogn) Solution
    public int minSubArrayLenBinarySearch(int s, int[] nums) {
        if (s < 0 || nums == null) return 0;
        int lo = 0;
        // Remember the upper bound is the total length of the array!
        int hi = nums.length;
        int minSize = 0;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (existWindow(nums, mid, s)) {
                hi = mid - 1;
                minSize = mid;
            } else {
                lo = mid + 1;
            }
        }
        return minSize;
    }

    public boolean existWindow(int[] nums, int windowSize, int s) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= windowSize) sum -= nums[i - windowSize];
            sum += nums[i];
            if (sum >= s) return true;
        }
        return false;
    }

    // O(n) Time O(1) Space
    public int minSubArrayLen(int s, int[] nums) {
        if (s < 0 || nums == null) return 0;
        int minSize = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        while (right < nums.length) {
            // Expand the window to the right until we find a sum >= target
            while (right < nums.length && currentSum < s) currentSum += nums[right++];
            // Shrink the window from the left until the sum < target
            while (left < right && currentSum >= s) {
                minSize = Math.min(minSize, right - left);
                currentSum -= nums[left++];
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
