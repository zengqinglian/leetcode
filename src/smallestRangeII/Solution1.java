package smallestRangeII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {
    // Sliding window solution - 150 ms. slow solution
    /*
     * find all pos value we can get, then use sliding window which make window
     * contians all index, then foreach window find min
     */
    public int smallestRangeII(int[] A, int K) {
	int l = A.length;
	List<int[]> a = new ArrayList<>();
	int idx = 0;
	for (int i : A) {
	    a.add(new int[] { i - K, idx });
	    a.add(new int[] { i + K, idx++ });
	}
	Collections.sort(a, (m, n) -> {
	    return m[0] - n[0];
	});
	int i = 0, j = 0;
	int[] map = new int[l];
	l = a.size();
	int cnt = 0;
	int min = Integer.MAX_VALUE;
	while (i < l) {
	    if (cnt != l / 2) {
		if (map[a.get(i++)[1]]++ == 0) {
		    cnt++;
		}
	    } else {
		min = Math.min(a.get(i - 1)[0] - a.get(j)[0], min);
		if (--map[a.get(j++)[1]] == 0)
		    cnt--;
	    }
	}
	return min;

    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[] A = { 1, 3, 6 };
	s.smallestRangeII(A, 3);
    }
}
