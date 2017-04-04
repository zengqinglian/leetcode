package jumpGame;

public class Solution1 {
    // improvement
    public boolean canJump(int[] nums) {
        if(nums.length<=1){
            return true;
        }

        int max = nums[0];
        if (max >= nums.length - 1) {
            return true;
        }
        if (max <= 0) {
            return false;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (max < i + nums[i]) {
                max = i + nums[i];
                if (max >= nums.length - 1) {
                    return true;
                }
            } else if (max <= i) {
                return false;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int[] nums = { 3, 0, 8, 2, 0, 0, 1 };
        Solution1 s = new Solution1();
        s.canJump(nums);
    }
}
