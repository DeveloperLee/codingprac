package arrayprocess;

/**
 * Created by EricLee on 10/19/16.
 */
public class MoveZeros {

    // O(N) Time O(1) Space
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int currentPos = 0;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != 0) {
                nums[currentPos++] = nums[index];
            }
            index++;
        }
        while (currentPos < nums.length) {
            nums[currentPos++] = 0;
        }
    }
}
