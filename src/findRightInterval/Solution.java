package findRightInterval;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    // 16ms solution, beat 70%
    public int[] findRightInterval(int[][] intervals) {
	TreeMap<Integer, Integer> tMap = new TreeMap<>();
	for (int i=0; i<intervals.length; i++) {
	    tMap.put(intervals[i][0], i);
	}
	
	int[] result = new int[intervals.length];
	for (int i = 0; i < intervals.length; i++) {
	    int right = intervals[i][1];
	    Map.Entry<Integer, Integer> entry = tMap.ceilingEntry(right);
	    int index = entry == null ? -1 : entry.getValue();
	    result[i] = index;
	}

	return result;
    }
}
