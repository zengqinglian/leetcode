package longestWellPerformingInterval;

import java.util.LinkedList;
import java.util.List;

//88ms solution , beat 40%
public class Solution {
    public int longestWPI(int[] hours) {
	List<Integer> li = new LinkedList<>();
	for (int i = 0; i < hours.length; i++) {
	    if (hours[i] > 8) {
		li.add(i);
	    }
	}
	int max = 0 ;
	if(!li.isEmpty()) {
	    max =1;
	}
	for (int i = 0; i < li.size(); i++) {
	    for (int j = li.size() - 1; j > i; j--) {
		int total = j - i + 1;
		if (2 * total - 1 >= hours.length) {
		    return hours.length;
		} else {
		    if (2 * total - 1 >= li.get(j) - li.get(i) + 1) {
			max = Math.max(max, 2 * total - 1);
			break;
		    }
		}
	    }
	}

	return max;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] hours = { 8, 10, 6, 16, 5 };
	s.longestWPI(hours);
    }
}
