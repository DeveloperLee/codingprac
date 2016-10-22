package search.binarysearch;

/**
 * Created by EricLee on 10/21/16.
 */
public class Sqrt {

    public int mySqrt(int x) {
        if (x < 0) return -1;
        int lo = 0;
        int hi = x;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (x / mid == mid) return mid;
            if (x / mid > mid) {
                if (x / (mid + 1) < mid + 1) return mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
