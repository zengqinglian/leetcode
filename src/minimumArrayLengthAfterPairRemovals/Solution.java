package minimumArrayLengthAfterPairRemovals;

import java.util.*;
/*
Runtime
34ms
Beats 42.94%
Analyze Complexity
Memory
62.06 MB
Beats 24.29%
 */
public class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            int val = map.getOrDefault(num, 0) + 1;
            map.put(num, val);
            max = Math.max(max, val);
        }
        if (max > nums.size() /2) {
            return 2*max - nums.size();
        }else {
            if (nums.size() % 2== 1) {
                return 1;
            }else{
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> nums = Arrays.asList(1,1,1);
        solution.minLengthAfterRemovals(nums);
    }
}
