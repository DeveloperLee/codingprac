package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by EricLee on 10/17/16.
 */
public class MergeIntervals {

    // O(nlogn + n) Time and O(1) Space (excluding the result list)
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Interval cursorInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            if (currentInterval.start <= cursorInterval.end) {
                cursorInterval.end = Math.max(currentInterval.end, cursorInterval.end);
            } else {
                result.add(cursorInterval);
                cursorInterval = currentInterval;
            }
        }
        result.add(cursorInterval);
        return result;
    }
}
