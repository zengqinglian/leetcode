package numberofIslands;

public class Solution1 {
    // recursive solution
    public int numIslands(char[][] grid) {

        int i = 0, y = 0, x = 0;
        for (x = 0; x < grid.length; x++) {
            for (y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == '1') {
                    function(grid, x, y);
                    i++;
                }
            }
        }
        return i;

    }

    public void function(char[][] grid, int x, int y) {
        if (grid[x][y] == '0')
            return;
        grid[x][y] = '0';
        if (x - 1 >= 0)
            function(grid, x - 1, y);
        if (y - 1 >= 0)
            function(grid, x, y - 1);
        if (x + 1 < grid.length)
            function(grid, x + 1, y);
        if (y + 1 < grid[0].length)
            function(grid, x, y + 1);
    }
}
