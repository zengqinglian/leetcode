package leetcode4Sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    // someone's solution beat 80%
    public List<List<Integer>> fourSum(int[] nums, int target) {
	List<List<Integer>> list = new LinkedList<>();
	Arrays.sort(nums);
	for (int i = 0; i < nums.length - 3;) {
	    for (int j = i + 1; j < nums.length - 2;) {
		int lo = j + 1, hi = nums.length - 1;
		while (lo < hi) {
		    if (nums[i] + nums[j] + nums[lo] + nums[hi] == target) {
			list.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
			while (lo < hi && nums[++lo] == nums[lo - 1])
			    ;
			while (lo < hi && nums[--hi] == nums[hi + 1])
			    ;
		    } else if (nums[i] + nums[j] + nums[lo] + nums[hi] < target)
			lo++;
		    else
			hi--;
		}
		while (j < nums.length - 2 && nums[++j] == nums[j - 1])
		    ;
	    }
	    while (i < nums.length - 3 && nums[++i] == nums[i - 1])
		;
	}
	return list;
    }
}
