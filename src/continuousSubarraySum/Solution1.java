package continuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    // O(N) solution
    /*
     * We iterate through the input array exactly once, keeping track of the
     * running sum mod k of the elements in the process. If we find that a
     * running sum value at index j has been previously seen before in some
     * earlier index i in the array, then we know that the sub-array (i,j]
     * contains a desired sum. Similar to question :
     * 
     * https://leetcode.com/problems/contiguous-array/?tab=Description
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;

        if (length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
            {
                put(0, -1);
            }
        }; // init map
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            if (k != 0)
                runningSum %= k;
            Integer prev = map.get(runningSum);
            if (prev != null) {
                if (i - prev > 1)
                    return true;
            } else
                map.put(runningSum, i);
        }
        return false;
    }
}
