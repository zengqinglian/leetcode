package outofBoundaryPaths;
/*
Without Cache
Time Limit Exceeded
76 / 94 testcases passed

WIth Cache
Runtime
5 ms
Beats
65.18%
Memory
43.5 MB
Beats
16.96%
 */
public class Solution {

    int[] X = {1,-1,0,0};
    int[] Y = {0,0,1,-1};
    Integer[][][] cache;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.cache = new Integer[m][n][maxMove+1];
        int ans= findPaths(m,n, maxMove, startRow, startColumn, 0);
        return ans;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn, int currentMove) {
        if(currentMove==maxMove) {
            return 0;
        }
        if ( cache[startRow][startColumn][maxMove-currentMove] !=null){
            return cache[startRow][startColumn][maxMove-currentMove];
        }
        int path = 0;
        for (int i=0; i<4; i++) {
            int newStartRow = startRow + X[i];
            int newStartCol = startColumn + Y[i];
            if (newStartRow>=0 && newStartRow<m && newStartCol>=0 && newStartCol<n) {
                path = (path + findPaths(m, n, maxMove, newStartRow, newStartCol, currentMove+1)) % 1_000_000_007;
            }else{
                path++;
            }
        }
        cache[startRow][startColumn][maxMove-currentMove] = path;
        return path;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findPaths(2,2,2,0,0);
    }
}
