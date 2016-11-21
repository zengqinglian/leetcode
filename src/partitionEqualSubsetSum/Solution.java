package partitionEqualSubsetSum;

import java.util.Arrays;

public class Solution {
    // over time limit
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }

        if (total % 2 == 1) {
            return false;
        }

        int target = total / 2;
        Arrays.sort(nums);
        return findTarget(nums, target, 0);

    }

    private boolean findTarget(int[] nums, int target, int i) {
        for (int j = i; j < nums.length; j++) {
            if (nums[j] == target) {
                return true;
            } else if (nums[j] < target) {
                if (findTarget(nums, target - nums[j], j + 1) || findTarget(nums, target, j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

}
