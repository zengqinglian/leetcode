package globalAndLocalInversions;
/*
2ms
Beats 47.78%
Analyze Complexity
Memory
57.22 MB
Beats 70.56%

 */
public class Solution2 {
    public boolean isIdealPermutation(int[] nums) {
        if (nums.length ==1) {
            return true;
        }
        int max = -1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]>=nums[i-1]) {
                if (max>=nums[i]) {
                    return false;
                }
            }else{
                if (max>=nums[i]) {
                    return false;
                }
            }
            max = Math.max(max, nums[i-1]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isIdealPermutation(new int[]{0,2,1}));
    }
}
