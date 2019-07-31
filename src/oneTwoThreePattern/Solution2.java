package oneTwoThreePattern;

public class Solution2 {
    // someone's o(N*N) solution, beat 20%
    public boolean find132pattern(int[] nums) {
	int min_i = Integer.MAX_VALUE;
	for (int j = 0; j < nums.length - 1; j++) {
	    min_i = Math.min(min_i, nums[j]);
	    for (int k = j + 1; k < nums.length; k++) {
		if (nums[k] < nums[j] && min_i < nums[k])
		    return true;
	    }
	}
	return false;
    }
}
