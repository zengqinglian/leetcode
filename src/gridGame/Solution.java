package gridGame;
/*
Runtime
4ms
Beats 91.61%
Analyze Complexity
Memory
57.36 MB
Beats
89.38%
 */
public class Solution {
    public long gridGame(int[][] grid) {
        long totalLevel0=0;
        for (int i=0; i<grid[0].length; i++){
            totalLevel0 += grid[0][i];
        }
        long min = Long.MAX_VALUE;
        long level0Val = totalLevel0;
        long level1Val = 0;
        for (int i=0; i<grid[0].length; i++) {
            level0Val-= grid[0][i];
            if (i-1>=0) {
                level1Val +=  grid[1][i-1];
            }
            long maxL0L1 = Math.max(level0Val, level1Val);
            min = Math.min(min, maxL0L1);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1,3,1,15},{1,3,3,1}};
        s.gridGame(grid);
    }


}
