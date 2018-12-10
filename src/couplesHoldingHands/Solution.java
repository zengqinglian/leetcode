package couplesHoldingHands;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 5ms solution , beat 25%
    public int minSwapsCouples(int[] row) {
	Map<Integer, Integer> map = new HashMap<>();
	int counter = 0;
	for (int i = 0; i < row.length; i++) {
	    Integer v = null;
	    if (row[i] % 2 == 0) {
		v = map.get(row[i] + 1);
	    } else {
		v = map.get(row[i] - 1);
	    }

	    if (v != null) {
		if (v % 2 == 0) {
		    if (v.intValue() + 1 != i) {
			counter++;
			map.put(row[v.intValue() + 1], i);
			row[i] = row[v.intValue() + 1];
		    }
		} else {
		    counter++;
		    map.put(row[v.intValue() - 1], i);
		    row[i] = row[v.intValue() - 1];
		}

	    } else {
		map.put(row[i], i);
	    }
	}
	return counter;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] row = { 5, 4, 2, 6, 3, 1, 0, 7 };
	s.minSwapsCouples(row);
    }
}
