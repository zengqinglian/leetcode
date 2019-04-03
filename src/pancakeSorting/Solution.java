package pancakeSorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 3ms solution ,beat 90%
    public List<Integer> pancakeSort(int[] A) {

	List<Integer> res = new ArrayList<>();

	Map<Integer, Integer> map = new HashMap<>();
	for (int i = 0; i < A.length; i++) {
	    map.put(A[i], i);
	}

	for (int i = A.length; i >= 1; i--) {
	    flip(map, A, i, res);
	}

	return res;

    }

    private void flip(Map<Integer, Integer> map, int[] A, int i, List<Integer> res) {
	int idx = map.get(i);
	if (idx + 1 != i) {
	    if (idx != 0) {
		res.add(idx + 1);
		swap(A, idx, map);
	    }
	    res.add(i);
	    swap(A, i - 1, map);
	}
    }

    private void swap(int[] A, int idx, Map<Integer, Integer> map) {
	int i = 0;
	int j = idx;
	while (i < j) {
	    map.put(A[i], j);
	    map.put(A[j], i);
	    int temp = A[j];
	    A[j] = A[i];
	    A[i] = temp;
	    i++;
	    j--;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 3, 2, 4, 1 };
	s.pancakeSort(A);
    }
}
