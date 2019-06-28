package longestRepeatingCharacterReplacement;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    // over time limit 23 / 37 test cases passed.
    public int characterReplacement(String s, int k) {
	boolean[] marker = new boolean[26];
	int max = 0;
	for (char c : s.toCharArray()) {
	    if (marker[c - 'A']) {
		continue;
	    } else {
		max = Math.max(max, getMaxLen(s, k, c));
		marker[c - 'A'] = true;
	    }
	}
	return max;
    }

    private int getMaxLen(String s, int k, char chr) {
	List<int[]> li = new LinkedList<>();
	int max = 0;
	for (char c : s.toCharArray()) {
	    if (c == chr) {
		if (li.isEmpty()) {
		    int[] v = { k, 1 };
		    li.add(v);
		} else {
		    for (int[] v : li) {
			if (v[0] >= 0)
			    v[1]++;
		    }
		}
	    } else {
		if (li.isEmpty()) {
		    int[] noChange = { k, 0 };
		    li.add(noChange);
		    if (k > 0) {
			int[] v = { k - 1, 1 };
			li.add(v);
		    }
		} else {
		    for (int[] v : li) {
			if (v[0] > 0) {
			    v[0]--;
			    v[1]++;
			} else if (v[0] == 0) {
			    v[0]--;
			}
		    }
		    int[] noChange = { k, 0 };
		    li.add(noChange);
		}
	    }

	}
	for (int[] v : li) {
	    max = Math.max(max, v[1]);
	}
	return max;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.characterReplacement("AABABBA", 2);
    }
}
