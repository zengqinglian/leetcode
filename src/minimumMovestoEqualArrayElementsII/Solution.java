package minimumMovestoEqualArrayElementsII;

public class Solution {
    // overtime limmit solution
    public int minMoves2(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    dp[i][j] = 0;
                } else {
                    int diff = Math.abs(nums[i] - nums[j]);
                    dp[i][j] = diff;
                    dp[j][i] = diff;
                }
            }
        }

        long result = Long.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            long total = 0;
            for (int j = 0; j < length; j++) {
                total += dp[i][j];
            }
            result = Math.min(result, total);
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 203125577, -349566234, 230332704, 48321315, 66379082, 386516853, 50986744, -250908656,
                -425653504, -212123143 };
        s.minMoves2(nums);
    }
}
