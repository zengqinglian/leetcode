package lastStoneWeightII;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 12ms solution, beat 15%
    public int lastStoneWeightII(int[] stones) {
	Set<Integer> pos = new HashSet<>();
	pos.add(0);
	for (int i = 0; i < stones.length - 1; i++) {
	    int stone = stones[i];
	    Set<Integer> new_pos = new HashSet<>();
	    for (int v : pos) {
		new_pos.add(v + stone);
		new_pos.add(v - stone);
	    }
	    pos = new_pos;

	}
	int val = stones[stones.length-1];
	for(int i=0; i<3000; i++) {
	    int v = val + i;
	    if (pos.contains(-v)) {
		return i;
	    }
	    int v2 = -val + i;
	    if (pos.contains(-v2)) {
		return i;
	    }
	}
	
	return 3000;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] stones = { 1, 2 };
	s.lastStoneWeightII(stones);
    }
}
