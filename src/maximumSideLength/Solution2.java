package maximumSideLength;

public class Solution2 {
    //someone's dp solution. beat 50%
    public int maxSideLength(int[][] mat, int threshold) {
        int res = 0, l = 0;
        int row = mat.length, col = mat[0].length;
        int[][] dp = new int[row+1][col+1];
        //1 求dp
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mat[i-1][j-1];
            }
        }

        for(int i=0;i<=row;i++){
            for(int j=0;j<=col;j++){
                while(i+l<=row && j+l<=col && dp[i+l][j+l] - dp[i+l][j] - dp[i][j+l] + dp[i][j] <= threshold){
                    res = l;
                    l++;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[][] mat = {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        s.maxSideLength(mat, 4);
    }

}
