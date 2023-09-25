package singleElementinaSortedArray;
/*
Runtime
1 ms
Beats
25.25%
Memory
50.1 MB
Beats
35.84%
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int idx = 0;
        while(idx<nums.length) {
            if (idx+1<nums.length) {
                if (nums[idx] != nums[idx+1]) {
                    return nums[idx];
                }
            }
            idx+=2;
        }
        return nums[nums.length-1];
    }
}
