package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EricLee on 10/20/16.
 */
public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        for (int i = 0; i <= nums.length; i++) {
            dfs(result, new ArrayList<Integer>(), nums, i, 0);
        }
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> holder, int[] nums, int size, int position) {
        if (holder.size() == size) {
            result.add(new ArrayList<>(holder));
        } else {
            for (int i = position; i < nums.length; i++) {
                holder.add(nums[i]);
                dfs(result, holder, nums, size, i + 1);
                holder.remove(holder.size() - 1);
            }
        }
    }
}
