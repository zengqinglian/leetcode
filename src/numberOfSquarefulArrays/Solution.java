package numberOfSquarefulArrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    // 3ms solution , beat 80%
    public int numSquarefulPerms(int[] A) {
	// group
	Map<Integer, Set<Integer>> map = new HashMap<>();
	Map<Integer, Integer> cntMap = new HashMap<>();

	for (int i = 0; i < A.length; i++) {
	    Set<Integer> s = map.get(A[i]);
	    Integer cnt = cntMap.get(A[i]);
	    if(s == null) {
		s= new HashSet<>();
		map.put(A[i], s);
	    }
	    if (cnt == null) {
		cntMap.put(A[i], 1);
	    } else {
		cntMap.put(A[i], cnt + 1);
	    }

	    for (int j = 0; j < A.length; j++) {
		if (i != j && checkSquare(A[i] + A[j]))
		    s.add(A[j]);
	    }
	}

	int res = 0;
	for (int v : map.keySet()) {
	    int len = 1;
	    res += check(len, A.length, v, map, cntMap, new HashMap<Integer, Integer>());
	}

	return res;

    }

    private boolean checkSquare(int v) {
	double root = Math.sqrt(v);
	if(Math.floor(root) == root) {
	    return true;
	}else {
	    return false;
	}
    }

    private int check(int i, int Len, int v, Map<Integer, Set<Integer>> map, Map<Integer, Integer> cntMap,
	    Map<Integer, Integer> newCntMap) {

	if (newCntMap.containsKey(v) && newCntMap.get(v) >= cntMap.get(v)) {
	    return 0;
	}

	if (newCntMap.containsKey(v)) {
	    newCntMap.put(v, newCntMap.get(v) + 1);
	} else {
	    newCntMap.put(v, 1);
	}

	if (i == Len) {
	    newCntMap.put(v, newCntMap.get(v) - 1);
	    return 1;
	}

	Set<Integer> availables = map.get(v);
	if (availables.size() == 0) {
	    newCntMap.put(v, newCntMap.get(v) - 1);
	    return 0;
	}

	int res = 0;
	for (int val : availables) {
	    res += check(i + 1, Len, val, map, cntMap, newCntMap);
	}
	newCntMap.put(v, newCntMap.get(v) - 1);
	return res;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 2, 2, 2, 7, 14 };
	s.numSquarefulPerms(A);
    }

}
