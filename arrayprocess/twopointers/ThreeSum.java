package arrayprocess.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by EricLee on 10/19/16.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 2) return result;
        Arrays.sort(nums);
        int first = 0;
        while (first < nums.length - 2) {
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                    while (++second < third && nums[second] == nums[second - 1]);
                    while (second < --third && nums[third] == nums[third  + 1]);
                } else if (sum < 0) {
                    while (++second < third && nums[second] == nums[second - 1]);
                } else {
                    while (second < --third && nums[third] == nums[third  + 1]);
                }
            }
            while (++first < nums.length - 2 && nums[first] == nums[first - 1]);
        }
        return result;
    }
}
