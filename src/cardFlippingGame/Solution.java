package cardFlippingGame;

public class Solution {
    // 11ms solution beat 90%
    public int flipgame(int[] fronts, int[] backs) {

	boolean[] checker = new boolean[2001];

	for (int i = 0; i < fronts.length; i++) {
	    int f = fronts[i];
	    int b = backs[i];
	    if (f == b) {
		checker[f] = true;
	    }
	}

	int val = Integer.MAX_VALUE;
	for (int i = 1; i <= backs.length; i++) {
	    if (backs[i - 1] != fronts[i - 1]) {
		if (!checker[backs[i - 1]]) {
		    val = Math.min(val, backs[i - 1]);
		}

		if (!checker[fronts[i - 1]]) {
		    val = Math.min(val, fronts[i - 1]);
		}

	    }
	}
	if (val != Integer.MAX_VALUE) {
	    return val;
	}

	return 0;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] fronts = { 1, 2 };
	int[] backs = { 1, 1 };
		
	s.flipgame(fronts, backs);
    }
}
