package sorting;

/**
 * Created by EricLee on 10/16/16.
 */
public class SortColor {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int zeroPos = 0;
        int twoPos = nums.length - 1;
        int cursor = 0;
        while (cursor <= twoPos) {
            while (cursor <= twoPos && nums[cursor] == 2) swap(nums, cursor, twoPos--);
            while (cursor <= twoPos && zeroPos <= cursor && nums[cursor] == 0) swap(nums, cursor, zeroPos++);
            cursor++;
        }
    }

    public void swap(int[] nums, int lo, int hi) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }
}
