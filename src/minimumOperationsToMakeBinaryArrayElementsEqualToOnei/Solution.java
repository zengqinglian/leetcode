package minimumOperationsToMakeBinaryArrayElementsEqualToOnei;

public class Solution {
    public int minOperations(int[] nums) {
        int startIdx = 0;
        int cnt = 0;
        while (startIdx < nums.length-2) {
            if (nums[startIdx] != 1) {
                nums[startIdx]=1;
                nums[startIdx+1]= nums[startIdx+1] ==0? 1: 0;
                nums[startIdx+2]= nums[startIdx+2] ==0? 1: 0;
                cnt++;
            }
            startIdx++;
        }
        for (int v : nums) {
            if (v == 0) {
                return -1;
            }
        }
        return cnt;
    }
}
