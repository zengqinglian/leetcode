package movementofRobots;

import java.util.Arrays;

/*
Runtime
14 ms
Beats
99.70%
Memory
54.9 MB
Beats
51.32%
 */
public class Solution {
    public int sumDistance(int[] nums, String s, int d) {
        for (int i=0; i<nums.length; i++) {
            char direction = s.charAt(i);
            if (direction == 'R') {
                nums[i]+=d;
            }else{
                nums[i]-=d;
            }
        }
        long res =0;
        Arrays.sort(nums);
        int times = nums.length-1;
        for (int i=0; i<nums.length/2; i++) {
            int lastIndex = nums.length -1- i;
            long diff = (long)nums[lastIndex] - (long)nums[i];
            diff = times * diff;
            diff = diff % 1_000_000_007L;
            times -=2;
            res = (res + diff)% 1_000_000_007L;
        }

        return (int)res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-2,0,2,3};
        s.sumDistance(nums, "RLLR", 3);
    }
}
