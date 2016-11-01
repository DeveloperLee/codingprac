package arrayprocess.twopointers;

/**
 * Created by EricLee on 10/22/16.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            while (head <= tail && nums[head] == val) {
                nums[head] = nums[tail--];
            }
            // Remember to check this
            if (head > tail) break;
            head++;
        }
        return head;
    }
}
