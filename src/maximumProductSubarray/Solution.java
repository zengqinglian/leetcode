package maximumProductSubarray;

public class Solution {
    // 1ms solution beat 90% O(N)
    public int maxProduct(int[] nums) {
	int[] dpMax = new int[nums.length];
	int[] dpMin = new int[nums.length];

	int max = nums[0];

	if (nums[0] > 0) {
	    dpMax[0] = nums[0];
	} else {
	    dpMin[0] = nums[0];
	}


	for (int i = 1; i < nums.length; i++) {
	    if (nums[i] > 0) {
		dpMax[i] = Math.max(dpMax[i - 1] * nums[i], nums[i]);
		dpMin[i] = dpMin[i - 1] * nums[i];
	    } else if (nums[i] < 0) {
		dpMax[i] = dpMin[i - 1] * nums[i];
		dpMin[i] = Math.min(dpMax[i - 1] * nums[i], nums[i]);
	    } else {
		dpMax[i] = 0;
		dpMin[i] = 0;
	    }

	    max = Math.max(dpMax[i], max);
	}

	return max;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] nums = { 2, 3, -2, 4, -2, 0, 1, 2, 3 };
	s.maxProduct(nums);
    }
}
