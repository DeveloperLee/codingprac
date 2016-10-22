package arrayprocess.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by EricLee on 10/21/16.
 *
 * The intuition of this method is to record the sum till this current point. We can get the sum of any
 * range inside the array by subtract a smaller interval from a larger interval.
 * For example, we can get [2,10] by [0, 10] - [0, 2]. So the only thing we need to check is whether such
 * a subtraction exists in the map, [a, b] - [a, c] = k  => [a, c] = [a, b] - k
 */
public class MaxSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) max = i + 1;
            // Check whether [a, c] = [a, b] - k exists in the map.
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            map.putIfAbsent(sum, i);
        }
        return max;
    }
}
