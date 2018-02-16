package nextPermutation;

public class Solution {
    // 19 ms solution - beat 50%
    public void nextPermutation(int[] nums) {
	int index = -1;
	int s = nums.length - 1;
	while (s >= 1) {
	    if (nums[s] > nums[s - 1]) {
		index = s - 1;
		break;
	    }
	    s--;
	}

	if (index < 0) {
	    int i = 0;
	    int j = nums.length - 1;

	    while (i < j) {
		swap(i, j ,nums);
		i++;
		j--;
	    }
	    return;
	}
	
	int start = index + 1;
	int target = start;
	while (start < nums.length) {
	    if (nums[start] > nums[index]) {
		target = start;
		start++;
	    } else {
		break;
	    }
	}

	swap(index, target, nums);
	index = index + 1;

	// Arrays.sort(nums, index, nums.length);
	int i = index;
	int j = nums.length - 1;
	while (i < j) {
	    swap(i, j, nums);
	    i++;
	    j--;
	}

    }

    private void swap(int i, int j, int[] nums) {
	int temp = nums[i];
	nums[i] = nums[j];
	nums[j] = temp;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] nums = { 5, 4, 7, 5, 3, 2 };
	s.nextPermutation(nums);
    }
}
