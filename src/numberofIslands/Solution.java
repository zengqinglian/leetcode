package numberofIslands;

import java.util.Stack;

public class Solution {
    // slow solution beat 10%
    public int numIslands(char[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        if (grid[0].length == 0) {
            return 0;
        }

        int result = 0;
        int[][] visited = new int[grid.length][grid[0].length];

        int[] startPoint = findNextStartPoint(visited, grid);

        while (startPoint != null) {
            result++;
            Stack<int[]> stack = new Stack<>();
            stack.push(startPoint);
            visited[startPoint[0]][startPoint[1]] = 1;
            while (!stack.isEmpty()) {
                int[] point = stack.pop();
                if (point[0] + 1 < grid.length && grid[point[0] + 1][point[1]] == '1'
                        && visited[point[0] + 1][point[1]] == 0) {
                    int[] newPoint = new int[2];
                    newPoint[0] = point[0] + 1;
                    newPoint[1] = point[1];
                    visited[point[0] + 1][point[1]] = 1;
                    stack.push(newPoint);
                }
                if (point[1] + 1 < grid[0].length && grid[point[0]][point[1] + 1] == '1'
                        && visited[point[0]][point[1] + 1] == 0) {
                    int[] newPoint = new int[2];
                    newPoint[0] = point[0];
                    newPoint[1] = point[1] + 1;
                    visited[point[0]][point[1] + 1] = 1;
                    stack.push(newPoint);
                }
                if (point[0] - 1 >= 0 && grid[point[0] - 1][point[1]] == '1' && visited[point[0] - 1][point[1]] == 0) {
                    int[] newPoint = new int[2];
                    newPoint[0] = point[0] - 1;
                    newPoint[1] = point[1];
                    visited[point[0] - 1][point[1]] = 1;
                    stack.push(newPoint);
                }

                if (point[1] - 1 >= 0 && grid[point[0]][point[1] - 1] == '1' && visited[point[0]][point[1] - 1] == 0) {
                    int[] newPoint = new int[2];
                    newPoint[0] = point[0];
                    newPoint[1] = point[1] - 1;
                    visited[point[0]][point[1] - 1] = 1;
                    stack.push(newPoint);
                }

            }
            startPoint = findNextStartPoint(visited, grid);
        }

        return result;
    }

    private int[] findNextStartPoint(int[][] visited, char[][] grid) {
        int[] ret = new int[2];
        for (int j = 0; j < visited[0].length; j++) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        s.numIslands(grid);
    }

}
