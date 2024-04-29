package numberOfBlackBlocks;
/*
Memory Limit Exceeded
2109 / 2145 testcases passed
 */
public class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        int[][] res = new int[m-1][n-1];
        for(int[] coord : coordinates) {
            int x = coord[0];
            int y = coord[1];
            if (x<m-1 && y<n-1) {
                res[x][y]++;
            }
            if (x-1>=0 && y<n-1) {
                res[x-1][y]++;
            }
            if (y-1>=0 && x<m-1) {
                res[x][y-1]++;
            }
            if (x-1>=0 && y-1>=0) {
                res[x-1][y-1]++;
            }
        }
        long[] r = new long[5];
        for(int i=0; i<res.length; i++) {
            for(int j=0; j<res[0].length; j++) {
                r[res[i][j]]++;
            }
        }
        return r;
    }
}
