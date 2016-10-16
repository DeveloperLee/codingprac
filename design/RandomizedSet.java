package design;

import java.util.*;

/**
 * Support get, set and getRandom function in O(1) time in average
 */
public class RandomizedSet {

    private Random random;
    private Map<Integer, Integer> map;
    private List<Integer> numberHolder;

    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        numberHolder = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, numberHolder.size());
            numberHolder.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            if (index != numberHolder.size() - 1) {
                numberHolder.set(index, numberHolder.get(numberHolder.size() - 1));
                map.put(numberHolder.get(index), index);
            }
            numberHolder.remove(numberHolder.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return numberHolder.get(random.nextInt(numberHolder.size()));
    }
}

