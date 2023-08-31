package minimumSizeSubarraySum;
/*
Runtime
2 ms
Beats
17.85%
Memory
55.5 MB
Beats
65.25%
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = nums[0];
        int i = 0;
        int j = i+1;
        int res = nums.length+1;
        while(i<j && i<nums.length) {
            if (sum<target) {
                if (j<nums.length) {
                    sum += nums[j++];
                }else{
                    break;
                }
            }else {
                int length = j-i;
                res = Math.min(length, res);
                sum -= nums[i++];
            }
        }
        if (res == nums.length+1) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums= {2,3,1,2,4,3};
        s.minSubArrayLen(7,nums);
    }
}
