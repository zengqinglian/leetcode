package longestWellPerformingInterval;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    // someone's solution, beat 80%
    public int longestWPI(int[] hours) {
	Map<Integer, Integer> map = new HashMap<>();
	// level -> first index
	int level = 0;
	int ans = 0;
	map.put(0, -1);
	for (int i = 0; i < hours.length; i++) {
	    if (hours[i] > 8)
		level++;
	    else
		level--;
	    if (!map.containsKey(level))
		map.put(level, i);

	    // find all level lower is available -> overall from low to high -> tiring more
	    // in the meantime: all level above 0, will have common min smaller level index
	    // at 0
	    if (level > 0)
		ans = Math.max(ans, i - map.get(0));
	    // for all level below 0, 1 step lower will always come first
	    else if (map.containsKey(level - 1)) {
		ans = Math.max(ans, i - map.get(level - 1));
	    }

	}
	return ans;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[] hours = { 9, 9, 6, 0, 6, 6, 9 };
	s.longestWPI(hours);
    }
}
