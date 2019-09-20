package lastStoneWeightII;

public class Solution1 {
    // 1ms solution , beat 99%
    public int lastStoneWeightII(int[] stones) {
	int total = stones[0];
	int[] plus_vals = new int[total+1];
	plus_vals[total] = 1;
	
	for (int i = 1; i < stones.length - 1; i++) {
	    int val = stones[i];
	    total += val;
	    int[] new_plus_vals = new int[total + 1];
	    for (int j = 0; j < plus_vals.length; j++) {
		if (plus_vals[j] == 1) {
		    new_plus_vals[j + val] = 1;
		    new_plus_vals[Math.abs(j - val)] = 1;
		}
	    }
	    plus_vals = new_plus_vals;
	}
	int val = stones[stones.length - 1];
	for (int i = 0; i < 3000; i++) {
	    int v = val + i;
	    int v2 = val - i;
	    if (v < plus_vals.length && (plus_vals[v] == 1)
		    || (v2 >= 0 && v2 < plus_vals.length && plus_vals[v2] == 1)) {
		return i;
	    }
	}

	return 3000;

    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[] stones = { 1, 2 };
	s.lastStoneWeightII(stones);
    }
}
