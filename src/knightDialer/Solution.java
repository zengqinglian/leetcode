package knightDialer;

public class Solution {
    // 23ms solution beat 80%
    public int knightDialer(int N) {
	if (N == 1) {
	    return 10;
	}

	int[][] base = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 3, 9, 0 }, {}, { 1, 7, 0 }, { 2, 6 }, { 1, 3 },
		{ 2, 4 } };

	int[] count = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

	for (int i = 1; i < N; i++) {
	    int[] newCount = new int[10];
	    for (int x = 0; x < 10; x++) {
		int[] shift = base[x];
		for (int v : shift) {
		    newCount[v] += count[x];
		    newCount[v] %= 1_000_000_007;
		}
	    }
	    count = newCount;
	}

	int total = 0;
	for (int v : count) {
	    total += v;
	    total %= 1_000_000_007;
	}
	return total;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.knightDialer(100);
    }
}
