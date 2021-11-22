package reducingDishes;

import java.util.Arrays;
/*
Runtime: 6 ms, faster than 26.02% of Java online submissions for Reducing Dishes.
Memory Usage: 39.1 MB, less than 30.09% of Java online submissions for Reducing Dishes.
 */
public class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[satisfaction.length+1][satisfaction.length];
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=satisfaction.length; i++) {
            for(int j=i-1; j<satisfaction.length; j++) {
                if(i==1) {
                    dp[i][j] = satisfaction[j];
                }else{
                    dp[i][j] = satisfaction[j] * i + dp[i-1][j-1];
                }
                if(j==satisfaction.length-1) {
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max<0?0:max;
    }
}
