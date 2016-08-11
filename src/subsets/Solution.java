package subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        if (nums.length == 0) {
            return result;
        }
        for (int i : nums) {
            List<List<Integer>> newResult = new ArrayList<>();
            for (List<Integer> li : result) {
                List<Integer> newList = new ArrayList<>(li);
                newList.add(i);
                newResult.add(newList);
            }
            result.addAll(newResult);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 2, 3 };
        s.subsets(nums);
    }
}
