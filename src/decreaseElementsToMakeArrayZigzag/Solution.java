package decreaseElementsToMakeArrayZigzag;

public class Solution {
    // 0ms solution , beat 100%
    public int movesToMakeZigzag(int[] nums) {
	if (nums.length <= 1) {
	    return 0;
	}

	if (nums.length == 2) {
	    if (nums[0] == nums[1]) {
		return 1;
	    } else {
		return 0;
	    }
	}

	int pre_odd_greater = nums[0];
	int pre_odd_smaller = nums[0]; 
	int cnt_odd_greater = 0;
	int cnt_odd_smaller = 0;
	for (int i = 1; i < nums.length; i++) {
	    if (i % 2 == 1) {
		if (pre_odd_greater > nums[i]) {
		    pre_odd_greater = nums[i];
		}else {
		    pre_odd_greater = pre_odd_greater - 1;
		    cnt_odd_greater += (nums[i] - pre_odd_greater);
		}

		if (pre_odd_smaller < nums[i]) {
		    pre_odd_smaller = nums[i];
		} else {
		    cnt_odd_smaller += (pre_odd_smaller - (nums[i] - 1));
		    pre_odd_smaller = nums[i];
		}
	    } else {

		if (pre_odd_greater < nums[i]) {
		    pre_odd_greater = nums[i];
		} else {
		    cnt_odd_greater += (pre_odd_greater - (nums[i] - 1));
		    pre_odd_greater = nums[i];
		}

		if (pre_odd_smaller > nums[i]) {
		    pre_odd_smaller = nums[i];
		} else {
		    pre_odd_smaller = pre_odd_smaller - 1;
		    cnt_odd_smaller += (nums[i] - pre_odd_smaller);
		}
	    }
	}
	return Math.min(cnt_odd_smaller, cnt_odd_greater);
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] nums = { 9, 6, 1, 6, 2 };
	s.movesToMakeZigzag(nums);
    }
}
