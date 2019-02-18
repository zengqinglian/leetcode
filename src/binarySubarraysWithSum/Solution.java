package binarySubarraysWithSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 26ms solution beat 50%.
    public int numSubarraysWithSum(int[] A, int S) {
	Map<Integer, Integer> map = new HashMap<>();
	int sum = 0;
	for (int a : A) {
	    sum += a;
	    Integer cnt = map.get(sum);
	    if (cnt == null) {
		map.put(sum, 1);
	    } else {
		map.put(sum, cnt + 1);
	    }

	}
	int res = 0;

	if (S == 0) {
	    for (int key : map.keySet()) {
		int n = map.get(key);
		if (key == 0) {
		    res += ((1 + n) * n / 2);
		} else {
		    res += (n * (n - 1) / 2);
		}
	    }

	    return res;

	}
	for (int key : map.keySet()) {
	    if (key == S) {
		int n =1;
		if(map.containsKey(0)) {
		    n += map.get(0);
		}
		res += (map.get(key) * n);
	    }
	    if (key > S) {
		int n1 = map.get(key);
		if (map.containsKey(key - S)) {
		    int n2 = map.get(key - S);
		    res += (n1 * n2);
		}

	    }
	}

	return res;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0 };
	s.numSubarraysWithSum(A, 3);
    }
}
