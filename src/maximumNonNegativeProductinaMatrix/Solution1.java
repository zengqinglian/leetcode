package maximumNonNegativeProductinaMatrix;
/*
Runtime: 2 ms, faster than 75.46% of Java online submissions for Maximum Non Negative Product in a Matrix.
Memory Usage: 41.4 MB, less than 23.31% of Java online submissions for Maximum Non Negative Product in a Matrix.
 */
public class Solution1 {
  int[] moveI = {-1, 0};
  int[] moveJ = {0, -1};
  public int maxProductPath(int[][] grid) {
    long[][][] dp= new long[grid.length][grid[0].length][2];
    dp[0][0][0] = grid[0][0];
    dp[0][0][1] = grid[0][0];
    for(int i=0; i<grid.length; i++){
      for(int j=0; j<grid[0].length; j++) {
        if(i==0 && j==0){
          continue;
        }
        long maxValue = Long.MIN_VALUE;
        long minValue = Long.MAX_VALUE;
        for(int x=0; x<2; x++) {
          int previousI = i + moveI[x];
          int previousJ = j + moveJ[x];
          if(previousI>=0 && previousI<grid.length
              && previousJ>=0 && previousJ<grid[0].length) {
            maxValue = Math.max(maxValue, dp[previousI][previousJ][0] * grid[i][j]);
            maxValue = Math.max(maxValue, dp[previousI][previousJ][1] * grid[i][j]);
            minValue = Math.min(minValue, dp[previousI][previousJ][0] * grid[i][j]);
            minValue = Math.min(minValue, dp[previousI][previousJ][1] * grid[i][j]);
          }
        }
        dp[i][j][0] = maxValue;
        dp[i][j][1] = minValue;
      }
    }
    if(dp[grid.length-1][grid[0].length-1][0] >=0) {
      return (int)(dp[grid.length-1][grid[0].length-1][0] % 1_000_000_007);
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[][] grid = {{-1,-4,2},{4,3,-1},{2,-4,4},{1,-1,-4}};
    s.maxProductPath(grid);
  }
}
