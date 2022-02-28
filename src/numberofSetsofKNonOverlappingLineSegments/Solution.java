package numberofSetsofKNonOverlappingLineSegments;
/*
Runtime: 67 ms, faster than 75.00% of Java online submissions for Number of Sets of K Non-Overlapping Line Segments.
Memory Usage: 53 MB, less than 81.94% of Java online submissions for Number of Sets of K Non-Overlapping Line Segments.
 */
public class Solution {
  public int numberOfSets(int n, int k) {
    int[][] dp = new int[k+1][n];
    for(int i=1;i<=k; i++) {
      int sum = 0;
      for(int j=0; j<n; j++) {
        if(i==1) {
          sum+=j;
          sum%=1_000_000_007;
          dp[i][j]=sum;
        }else{
          if(j-1>=0) {
            sum += (dp[i - 1][j - 1]);
            sum%=1_000_000_007;
          }
          if(j>=i){
            dp[i][j] = sum+dp[i][j-1];
            dp[i][j]%=1_000_000_007;
          }
        }
      }
    }
    return dp[k][n-1];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.numberOfSets(4, 2);
  }
}
