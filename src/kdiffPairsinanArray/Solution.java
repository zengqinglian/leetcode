package kdiffPairsinanArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    // sort the array
    // arrange two pointer to check diff
    // since sorted, we can loop through the array in O(N)
    // Over all limited N log(N) for sorting + O(N) to loop
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 1;

        int result =0;
        Set<Integer> set = new HashSet<>();
        while (right <= nums.length - 1 && left <= nums.length - 1) {
            if (left == right) {
                right++;
                continue;
            }
            if(Math.abs(nums[left] - nums[right])==k){
                if (set.contains(nums[left] + nums[right])) {
                    right++;
                    left++;
                    continue;
                } else {
                    set.add(nums[left] + nums[right]);
                    result++;
                    right++;
                    left++;
                }
            }else if(Math.abs(nums[left] - nums[right])<k){
                right++;
            } else {
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 3, 1, 3, 1, 1, 1 };
        s.findPairs(nums, 0);

    }
}
