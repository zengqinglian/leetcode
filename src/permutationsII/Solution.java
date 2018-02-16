package permutationsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    // 10ms solution - meet avg speed
    public List<List<Integer>> permuteUnique(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	generateList(nums, 0, result);
	return result;
    }

    private void generateList(int[] nums, int index, List<List<Integer>> result) {
	if (nums.length == index + 1) {
	    List<Integer> list = new ArrayList<>();
	    for (int i : nums) {
		list.add(i);
	    }
	    result.add(list);
	    return;
	}
	Set<Integer> dup = new HashSet<>();
	generateList(nums, index + 1, result);
	dup.add(nums[index]);

	for (int i = index + 1; i < nums.length; i++) {
	    if (!dup.contains(nums[i]) && nums[index] != nums[i]) {
		swap(nums, index, i);
		generateList(nums, index + 1, result);
		swap(nums, index, i);
		dup.add(nums[i]);
	    }
	}

    }

    private void swap(int[] nums, int a, int b) {
	int temp = nums[a];
	nums[a] = nums[b];
	nums[b] = temp;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] nums = { 1, 1, 2 };

	s.permuteUnique(nums);
    }

}
