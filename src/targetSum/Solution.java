package targetSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // recursive and over time limit
    public int findTargetSumWays(int[] nums, int S) {

        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            if (nums[0] == S || nums[0] == -1 * S) {
                return 1;
            } else {
                return 0;
            }
        }
        List<Integer> init = new ArrayList<>();

        init.add(nums[0]);
        init.add(-1 * nums[0]);

        return getPossibleResult(init, nums, 1, S);
    }

    private int getPossibleResult(List<Integer> possibleResults, int[] nums, int startIndex, int target) {
        if (startIndex == nums.length - 1) {
            int total = 0;
            for (int i : possibleResults) {
                if (i + nums[startIndex] == target) {
                    total++;
                }
                if (i - nums[startIndex] == target) {
                    total++;
                }
            }
            return total;
        }

        List<Integer> newPossibles = new ArrayList<>();
        for (int i : possibleResults) {
            newPossibles.add(i + nums[startIndex]);
            newPossibles.add(i - nums[startIndex]);
        }

        return getPossibleResult(newPossibles, nums, startIndex + 1, target);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 1, 1, 1, 1 };

        s.findTargetSumWays(nums, 3);
    }
}
