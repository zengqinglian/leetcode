package longestSubarrayof1AfterDeletingOneElement;
/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Subarray of 1's After Deleting One Element.
Memory Usage: 47.8 MB, less than 62.26% of Java online submissions for Longest Subarray of 1's After Deleting One Element.
 */
public class Solution {
    public int longestSubarray(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int res = 0;
        int i=0;
        int j=0;
        while(j<nums.length) {
            if(nums[j] == 0) {
                zeros++;
                while(zeros>1){
                   if(nums[i] == 0) {
                       zeros--;
                       i++;
                   }else{
                       ones--;
                       i++;
                   }
                }
            }else{
                ones++;
                res = Math. max(res, ones);
            }
            j++;
        }
        if(zeros == 0) {
            return res-1;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
