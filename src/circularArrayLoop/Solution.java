package circularArrayLoop;

public class Solution {
    // 0ms solution, beat 100%
    public boolean circularArrayLoop(int[] nums) {
	int index = 0;
	int basePlus = 1001;
	while (index < nums.length) {
	    if (nums[index] > 0 && nums[index] <= 1000 && nums[index] % nums.length != 0) {
		// int sum = 0;
		int cnt = 0;
		int i = index;
		while (nums[i] > 0 && nums[i] <= 1000 && nums[i] % nums.length != 0) {
		    int val = nums[i];
		    // sum += val;
		    cnt++;
		    // if (cnt > 1 && nums[i] == basePlus + index) {
		    // return true;
		    // }
		    nums[i] = basePlus + index;
		    i = i + val % nums.length;
		    if (i > nums.length - 1) {
			i = i - nums.length;
		    }
		    if (cnt > 1 && nums[i] == basePlus + index) {
			return true;
		    }

		}
	    }
	    index++;
	}
	index = 0;
	int baseMinus = -1001;
	while (index < nums.length) {
	    if (nums[index] < 0 && nums[index] >= -1000 && nums[index] % nums.length != 0) {
		// int sum = 0;
		int cnt = 0;
		int i = index;
		while (nums[i] < 0 && nums[i] >= -1000 && nums[i] % nums.length != 0) {
		    int val = nums[i];
		    // sum += val;
		    cnt++;
		    // if (cnt > 1 && nums[i] == baseMinus - index) {
		    // return true;
		    // }
		    nums[i] = baseMinus - index;
		    i = i + val % nums.length;
		    if (i < 0) {
			i = i + nums.length;
		    }
		    if (cnt > 1 && nums[i] == baseMinus - index) {
			return true;
		    }
		}
	    }
	    index++;
	}
	
	return false;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] nums = { -1, -2, -3, -4, -5 };
	s.circularArrayLoop(nums);

    }
}
