package numberofIslands;

public class Solution2 {
    int res = 0;
    int[] moveX = {1,-1,0,0};
    int[] moveY = {0,0,1,-1};
    public int numIslands(char[][] grid) {
        boolean[][] status = new boolean[grid.length][grid[0].length];
        for (int i=0-; i<grid.length;i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] =='1' && !status[i][j]) {
                    status[i][j] = true;
                    helper(i, j, status, grid);
                    res++;
                }
            }
        }
        return res;
    }

    private boolean helper (int x, int y, boolean[][] status, char[][] grid) {
        boolean hasLand = false;
        for (int s =0; s<4; s++) {
            int newX = x+ moveX[s];
            int newY = y + moveY[s];
            if (newX >=0 && newX<grid.length && newY >=0 && newY < grid[0].length && grid[newX][newY] == '1' && !status[newX][newY]) {
                status[newX][newY] = true;
                hasLand = helper(newX, newY, status, grid);
            }
        }
        return hasLand;
    }
}
