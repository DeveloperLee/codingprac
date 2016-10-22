package greedy;

/**
 * Created by EricLee on 10/20/16.
 *
 * This is a greedy two pass solution. The first pass is to select a candidate and second pass is to validate
 * whether the candidate from the first pass is indeed a celebrity.
 * From the first pass: 1. If a knows b, then a can't be a celebrity since a celebrity doesn't know anyone else
 *                         so b becomes a new candidate.
 *                      2. If a doesn't know b, then b can't be a celebrity and a is the potential candidate.
 * From the second pass: Test against everyone else to see whether the candidate is a celebrity.
 *
 */
public class FindCelebrity {

    // O(n) Time O(1) Space
    public int findCelebrity(int n) {
        if (n <= 0) return -1;
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) candidate = i;
        }

        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }

    // Pesudo function that returns whether a knows b
    public boolean knows(int a, int b) {
        return true;
    }
}
