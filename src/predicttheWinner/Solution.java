package predicttheWinner;

import java.util.Arrays;
/*
Runtime
2 ms
Beats
32.10%
Memory
39.5 MB
Beats
89.77%
 */
public class Solution {
    public boolean predictTheWinner(int[] nums) {
        int total = Arrays.stream(nums).sum();
        boolean res = checkwin(nums, 0, nums.length-1, total, 0, true);
        return res;
    }

    private boolean checkwin(int[] nums, int i, int j, int total, int p1Total, boolean p1) {
        if (p1Total >= total - p1Total)   {
            return true;
        }
        if (i>j){
            return false;
        }
        if (p1) {
            int head = nums[i];
            int tail = nums[j];
            return checkwin(nums, i+1, j, total, p1Total + head, !p1)
                    || checkwin(nums, i, j-1, total, p1Total + tail, !p1);
        }else{
            boolean res= checkwin(nums, i+1, j, total, p1Total, !p1) && checkwin(nums, i, j-1, total, p1Total, !p1);
            return res;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,1};
        s.predictTheWinner(nums);
    }

}
