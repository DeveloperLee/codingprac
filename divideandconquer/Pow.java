package divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EricLee on 10/21/16.
 */
public class Pow {

    // O(nlogn) Time O(logn) Stack space
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) return x * myPow(x, Integer.MAX_VALUE);
            n = -n;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
