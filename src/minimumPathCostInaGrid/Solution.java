package minimumPathCostInaGrid;


/*
6 ms solution, beat 95%
 */

public class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];

        for (int i=0; i<m-1; i++) {
            for(int j=0; j<n; j++) {
                int val = grid[i][j];
                for (int x=0; x<moveCost[val].length; x++) {
                    if (j==0) {
                        res[i+1][x] = val + moveCost[val][x] + res[i][j];
                    }else {
                        res[i+1][x]  = Math.min(res[i+1][x], val + moveCost[val][x] + res[i][j]);
                    }
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            ret = Math.min(ret, res[m-1][j]+grid[m-1][j]);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{5,3},{4,0},{2,1}};
        int[][] moveCost = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
        s.minPathCost(grid, moveCost);
    }
}
