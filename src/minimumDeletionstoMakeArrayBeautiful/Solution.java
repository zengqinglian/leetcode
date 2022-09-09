package minimumDeletionstoMakeArrayBeautiful;
/*
Runtime: 7 ms, faster than 55.80% of Java online submissions for Minimum Deletions to Make Array Beautiful.
Memory Usage: 93.1 MB, less than 78.99% of Java online submissions for Minimum Deletions to Make Array Beautiful.
 */
public class Solution {
    public int minDeletion(int[] nums) {
        if (nums.length==1) {
            return 1;
        }
        int index =0;
        int count=0;
        int nextIndex = index+1;
        while(index<nums.length-1 && nextIndex<nums.length) {
                if (nums[index] != nums[nextIndex]) {
                    index = nextIndex+1;
                    nextIndex=index+1;
                    count+=2;
                }else{
                    nextIndex++;
                }
        }
        return nums.length-count;
    }
}
