package burstBalloons;

public class Solution1
{
    public int maxCoins( int[] nums ) {
        // DP
        // This dp works in this way: we scan the array from len 2 to len n with all possible start points and end points. For each
        // combination, we will find the best way to burst balloons. dp[i][j] means we are looking at a combination with start point
        // at index i and end point at index j with len of j - i. In this combination, we use the third loop to find the best way to
        // burst. “nums[left] * nums[i] * nums[right]” means we burst all balloons from left to i and all ballons from i to right.
        // So only balloons left, i and right exits in current combination therefore we can do this operation. “+ dp[left][i] +
        // dp[i][right]” means add the value from best burst in range(left, i) and range(i, right).
        int[] newNums = new int[nums.length + 2];
        int n = 1;
        for( int x : nums ) {
            if( x > 0 ) {
                newNums[n++] = x;
            }
        }
        newNums[0] = newNums[n++] = 1;

        int[][] dp = new int[n][n];
        for( int k = 2; k < n; ++k ) {
            for( int left = 0; left < n - k; ++left ) {
                int right = left + k;
                for( int i = left + 1; i < right; ++i ) {
                    System.out.println( "DP[" + left + "][" + right + "] =" + " newNums[ " + left + "]" + newNums[left]
                            + "* newNums[" + i + "]" + newNums[i] + "* newNums[" + right + "]" + newNums[right] + " + dp[" + left
                            + "][" + i + "] " + dp[left][i] + " + dp[" + i + "][" + right + "] " + dp[i][right] + "="
                            + (newNums[left] * newNums[i] * newNums[right] + dp[left][i] + dp[i][right]) );
                    dp[left][right] = Math.max( dp[left][right], newNums[left] * newNums[i] * newNums[right] + dp[left][i]
                            + dp[i][right] );
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        int[] nums = { 3, 1, 5, 8 };
        s.maxCoins( nums );
    }
}
