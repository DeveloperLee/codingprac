package sorting;

/**
 * Created by EricLee on 10/18/16.
 *
 * This method is solved by the quick select algorithm, which is pretty similar to quick sort.
 * The difference is that we only interested in the kth largest number in the array, which is
 * (length - k + 1)th smallest in the array. We do the same thing as the quick sort but instead
 * of recursively sort the left and right part after putting the pivot value to the right position,
 * we return its index. If the index = length - k, it means that we just found the number we need.
 * If index > length - k, the kth largest number is on the left part of the current pivot. Otherwise right.
 */
public class FindKthElementInArray {

    public static void main(String[] args) {
        int[] array = {6,5,4,2,6,8,7};
        System.out.print(findKthLargest(array, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null) return -1;
        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int index = quickSelect(nums, lo, hi);
            if (index == k) return nums[k];
            if (index > k) hi = index - 1;
            else lo = index + 1;
        }
        return nums[k];
    }

    public static int quickSelect(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int pivot = nums[lo];
        while (i < j) {
            while (i < hi && nums[++i] < pivot);
            while (lo < j && nums[--j] > pivot);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    public static void swap(int[] nums, int lo, int hi) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }
}
