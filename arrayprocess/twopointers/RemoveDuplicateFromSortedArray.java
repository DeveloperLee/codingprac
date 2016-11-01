package arrayprocess.twopointers;

/**
 * Created by EricLee on 10/22/16.
 *
 * Maintain two pointers, first pointer move forward by 1 each time along the array and the other one keeps
 * track of the index of the next valid position.
 */
public class RemoveDuplicateFromSortedArray {

    // O(N) Time O(1) Space
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int position = 1;
        int cursor = 1;
        boolean dupOnce = false;
        while (cursor < nums.length) {
            if (nums[cursor] == nums[cursor - 1]) {
                if (!dupOnce) {
                    dupOnce = true;
                    nums[position++] = nums[cursor];
                }
            } else {
                dupOnce = false;
                nums[position++] = nums[cursor];
            }
            cursor++;
        }
        return position;
    }
}
