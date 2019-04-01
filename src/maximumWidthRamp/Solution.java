package maximumWidthRamp;

import java.util.TreeMap;

public class Solution {
    // over time limit solution
    public int maxWidthRamp(int[] A) {
	TreeMap<Integer, Integer> map = new TreeMap<>();
	int max = 0;
	for(int i=0; i<A.length; i++) {
	    Integer v = map.get(A[i]);
	    if(v == null) {
		map.put(A[i], i);
	    }else {
		max = Math.max(max, i-v);
	    }
	    
	    for (int val : map.headMap(A[i]).values()) {
		max = Math.max(max, i - val);
	    }
	}

	return max;
    }
}
