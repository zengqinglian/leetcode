package specialPermutations;

public class Solution {
    int MOD = 1000000007;
    int endMask;
    int[] nums;
    Integer[][] dp;

    public int specialPerm(int[] nums) {
        this.nums = nums;
        this.endMask = (int)Math.pow(2, nums.length)-1;
        this.dp = new Integer[this.endMask][nums.length];
        int ans = 0;

        //Finding permutation for every possible permutation
        for(int i = 0; i < nums.length; i++) {
            ans = ((ans % MOD) + (resolve((1 << i), i)) % MOD) % MOD;
        }
        return ans;
    }

    private int resolve(int mask, int last) {

        if (mask == endMask) {
            return 1;
        }
        if (dp[mask][last] !=null) {
            return dp[mask][last];
        }
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            if ( ((1<<i) & mask) ==0 && (nums[last]%nums[i] ==0 || nums[i] %nums[last] ==0)) {
                res = (res % MOD + resolve(((1<<i) | mask), i) % MOD) % MOD;
            }
        }
        dp[mask][last] = res;
        return res;
    }
}
