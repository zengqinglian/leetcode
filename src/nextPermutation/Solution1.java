package nextPermutation;

import java.util.Arrays;

public class Solution1 {
    public void nextPermutation(int[] nums) {
        int swap1 = -1;
        int swap2 = -1;
        for (int i = nums.length-1; i>=0; i--) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[j] < nums[i]) {

                    if (swap1<j){
                        swap1 = j;
                        swap2 = i;
                    }
                }
            }
        }
        if (swap1 >= 0) {
            int temp = nums[swap1];
            nums[swap1] = nums[swap2];
            nums[swap2] = temp;
            Arrays.sort(nums, swap1+1, nums.length);
            return;
        }
        for (int i=0, j = nums.length - 1; i<j; j--, i++) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
