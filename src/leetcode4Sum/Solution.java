package leetcode4Sum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
	Set<List<Integer>> result = new HashSet<>();
	helper(nums, 0, target, new ArrayList<Integer>(), result);
	List<List<Integer>> liRes = new ArrayList<>(result);
	return liRes;
    }

    private void helper(int[] nums, int index, int target, List<Integer> list, Set<List<Integer>> result) {
	if (list.size() == 3) {
	    for (int i = index; i < nums.length; i++) {
		if (nums[i] == target) {
		    list.add(nums[i]);
		    List<Integer> res = new ArrayList<>(list);
		    Collections.sort(res);
		    result.add(res);
		    list.remove(list.size() - 1);
		}
	    }
	} else {
	    for (int i = index; i < nums.length; i++) {
		list.add(nums[i]);
		for (int j = i + 1; j < nums.length; j++) {
		    helper(nums, j, target - nums[i], list, result);
		}
		list.remove(list.size() - 1);
	    }
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] nums = { 1, 0, -1, 0, -2, 2 };
	int target = 0;
	s.fourSum(nums, target);
    }
}
