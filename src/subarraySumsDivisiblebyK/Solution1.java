package subarraySumsDivisiblebyK;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    // still over time. use map , failed 63/73
    public int subarraysDivByK(int[] A, int K) {
	Map<Integer, Integer> map = new HashMap<>();
	int cnt = 0;
	for (int i = 0; i < A.length; i++) {
	    Map<Integer, Integer> newMap = new HashMap<>();
	    int val = A[i];
	    if (val % K == 0) {
		cnt++;
	    }
	    newMap.put(val, 1);
	    if (!map.isEmpty()) {
		for (int key : map.keySet()) {
		    int newKey = key + val;
		    if (newKey % K == 0) {
			cnt += map.get(key);
		    }
		    if (newMap.containsKey(newKey)) {
			newMap.put(newKey, map.get(key) + newMap.get(newKey));
		    } else {
			newMap.put(newKey, map.get(key));
		    }

		}
	    }
	    map = newMap;
	}
	return cnt;
    }
}
