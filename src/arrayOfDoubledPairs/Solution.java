package arrayOfDoubledPairs;

import java.util.TreeMap;

public class Solution {
    // 36ms solution , beat 90%
    public boolean canReorderDoubled(int[] A) {
	TreeMap<Integer, Integer> map = new TreeMap<>();

	for (int a : A) {
	    Integer cnt = map.get(a);
	    if (cnt == null) {
		map.put(a, 1);
	    } else {
		map.put(a, cnt + 1);
	    }
	}
	
	for(int key : map.keySet()) {

	    if (key > 0) {
		int v = map.get(key);
		if (v > 0) {
		    Integer val = map.get(2 * key);
		    if (val == null) {
			return false;
		    } else {
			if (val < v) {
			    return false;
			} else {
			    map.put(2 * key, val - v);
			}
		    }
		}
	    } else if (key == 0) {
		int v = map.get(key);
		if (v % 2 == 1) {
		    return false;
		}
	    } else {
		int v = map.get(key);
		if (v > 0) {
		    if (key % 2 == 1 || key % 2 == -1) {
			return false;
		    } else {

			Integer val = map.get(key / 2);
			if (val == null) {
			    return false;
			}
			if (v > val) {
			    return false;
			} else {
			    map.put(key / 2, val - v);
			}

		    }
		}
	    }

	    map.put(key, 0);
	}

	for (int key : map.keySet()) {
	    if (map.get(key) != 0) {
		return false;
	    }
	}

	return true;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { -6, -3 };
	s.canReorderDoubled(A);
    }
}
