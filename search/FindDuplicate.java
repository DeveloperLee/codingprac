package search;

/**
 * Created by EricLee on 10/17/16.
 *
 * This is a special case that we can apply binary search on an array to find the duplicate number.
 * The array is given by containing numbers from 1 to n (inclusive) and has n + 1 numbers. Appearently
 * at least 1 number is duplicated in the array. The idea for applying binary search is based on the
 * frequency of a given number in the array. If there's no duplication, the total occurrence of all
 * the numbers that is no greater than it (for example, 7) should be 7 (1,2,3,4,5,6,7). However, since
 * the array does contains duplication in it. The occurrence of all the numbers that is no greater than 7
 * is either less or greater than 7 -> Intuition of using binary search here. If the occurrence is less
 * than 7, it means that the duplicated number must be greater than 7, otherwise, the duplicate number
 * must be within 1~7.
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int lo = 1;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = getNumberLessThanNum(nums, mid);
            if (count <= mid) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public int getNumberLessThanNum(int[] nums, int num) {
        int count = 0;
        for (int number : nums) {
            if (number <= num) count++;
        }
        return count;
    }
}
