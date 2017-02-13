package pacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.List;

//DFS 18ms solution
//Split two oceans and find the points which beach can reach. and then compare two result of two oceans.
public class Solution2 {
    static int[][] diretion = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// y,x

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            pacific[i][0] = true;
            atlantic[i][matrix[0].length - 1] = true;
        }
        for (int j = 0; j < matrix[0].length; j++) {
            pacific[0][j] = true;
            atlantic[matrix.length - 1][j] = true;
        }
        for (int i = 0; i < matrix.length; i++) {
            dfs(pacific, matrix, i, 0);
            dfs(atlantic, matrix, i, matrix[0].length - 1);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dfs(pacific, matrix, 0, j);
            dfs(atlantic, matrix, matrix.length - 1, j);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j] == true)
                    res.add(new int[] { i, j });
            }
        }
        return res;

    }

    private void dfs(boolean[][] grid, int[][] matrix, int i, int j) {
        grid[i][j] = true;
        for (int d = 0; d < diretion.length; d++) {
            if (i + diretion[d][0] < grid.length && i + diretion[d][0] >= 0 && j + diretion[d][1] < grid[0].length
                    && j + diretion[d][1] >= 0 && grid[i + diretion[d][0]][j + diretion[d][1]] == false
                    && matrix[i + diretion[d][0]][j + diretion[d][1]] >= matrix[i][j])
                dfs(grid, matrix, i + diretion[d][0], j + diretion[d][1]);
        }
    }
}
