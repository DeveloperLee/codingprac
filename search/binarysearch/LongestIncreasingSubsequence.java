package search.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EricLee on 10/21/16.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> numbers = new ArrayList<>();
        numbers.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            processArray(numbers, nums[i]);
        }
        return numbers.size();
    }

    public void processArray(List<Integer> numbers, int number) {
        if (number > numbers.get(numbers.size() - 1)) {
            numbers.add(number);
        } else {
            int lo = 0;
            int hi = numbers.size() - 1;
            while (lo < hi) {
                int mid = lo + ((hi - lo) >> 1);
                if (numbers.get(mid) == number) return;
                if (numbers.get(mid) < number) lo = mid + 1;
                else hi = mid;
            }
            numbers.set(hi, number);
        }
    }
}
