package escapeTheGhosts;

public class Solution {
    // 4ms solution beat 70%
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
	int step = Math.abs(target[0]) + Math.abs(target[1]);

	for (int[] g : ghosts) {
	    if (Math.abs(target[0] - g[0]) + Math.abs(target[1] - g[1]) <= step) {
		return false;
	    }
	}

	return true;
    }

    public static void main(String[] args) {
	Solution s= new Solution();
	int[][] ghosts = { { 1, 9 }, { 2, -5 }, { 3, 8 }, { 9, 8 }, { -1, 3 } };
	int[] target = { 8, -10 };
	s.escapeGhosts(ghosts, target);
    }

}
