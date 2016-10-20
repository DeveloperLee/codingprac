package backtracking.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by EricLee on 10/19/16.
 */
public class PermutationWithoutDuplicate {

    // Iterative solution for permutation
    public List<List<Integer>> permuteIter(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        result.add(first);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> new_ans = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> currentLevel : result) {
                    List<Integer> newList = new ArrayList<>(currentLevel);
                    newList.add(j, nums[i]);
                    new_ans.add(newList);
                }
            }
            result = new_ans;
        }
        return result;
    }

    // A O(n^n + nlogn) Time + O(n) Space
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        getAllPermutations(result, nums, new ArrayList<Integer>(), used);
        return result;
    }

    public void getAllPermutations(List<List<Integer>> result, int[] nums, List<Integer> holder, boolean[] used) {
        if (holder.size() == nums.length) {
            result.add(new ArrayList<>(holder));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    holder.add(nums[i]);
                    getAllPermutations(result, nums, holder, used);
                    holder.remove(holder.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
