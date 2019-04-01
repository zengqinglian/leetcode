package maximumWidthRamp;

import java.util.Map.Entry;
import java.util.TreeMap;

public class Solution1 {
    // 72ms solution meet avg speed. beat 50%
    public int maxWidthRamp(int[] A) {
	TreeMap<Integer, int[]> map = new TreeMap<>();
	int max = 0;
	for (int i = 0; i < A.length; i++) {
	    int[] val = map.get(A[i]);
	    if (val == null) {
		val = new int[2];
	    }

	    Entry<Integer, int[]> last = map.floorEntry(A[i]);
	    if (last != null) {
		val[1] = i - last.getValue()[0] + last.getValue()[1];
	    } else {
		val[1] = 0;
	    }

	    val[0] = i;

	    map.put(A[i], val);

	    max = Math.max(max, val[1]);

	}

	return max;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[] A = { 9, 8, 1, 0, 1, 9, 4, 0, 4, 1 };
	s.maxWidthRamp(A);

    }
}
