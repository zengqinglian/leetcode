package insertDeleteGetRandomO1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    /** Initialize your data structure here. */
    private Map<Integer, Integer> map;
    public RandomizedSet() {
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already
     * contain the specified element.
     */
    public boolean insert(int val) {
        Integer i = map.putIfAbsent(val, val);
        if (i == null) {
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the
     * specified element.
     */
    public boolean remove(int val) {
        Integer i = map.remove(val);
        if (i == null) {
            return false;
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Integer[] array = new Integer[0];
        array = map.keySet().toArray(array);
        
        Random random = new Random();
        int answer = random.nextInt(array.length);
        
        return array[answer];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */