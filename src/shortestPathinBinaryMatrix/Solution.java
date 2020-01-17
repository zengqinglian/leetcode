package shortestPathinBinaryMatrix;

public class Solution {
    int[] X = {1,1,0,-1,1,-1,-1,0};
    int[] Y = {1,0,1,1,-1, 0,-1,-1};

    //over time limit solution ,  failed 45 / 84 [[0,1,0,0,1,1,0],[1,0,0,0,0,0,0],[1,0,0,1,1,1,1],[0,1,0,0,0,0,0],[1,0,0,0,0,0,1],[1,0,0,1,0,0,0],[1,0,1,0,0,1,0]]
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        boolean [][] visited = new boolean[grid.length][grid.length];
        int[] start = {0,0};
        visited[0][0] = true;
        int res = getShortest(grid, visited, start);
        if(res == -1){
            return -1;
        }
        return res+1;
    }

    private int getShortest(int[][] grid, boolean[][] visited, int[] start) {
        if(start[0] == grid.length-1 && start[1] == grid.length-1){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i=0; i<8; i++){
            int newX = start[0] + X[i];
            int newY = start[1] + Y[i];
            if(newX>=0 && newX<grid.length && newY>=0 && newY<grid.length){
                int[] newP = {newX, newY};
                if(!visited[newX][newY] && grid[newX][newY]==0){
                    visited[newX][newY] = true;
                    int shortest = getShortest(grid, visited, newP);
                    if(shortest >= 0) {
                        res = Math.min(res, 1 + shortest);
                    }
                    visited[newX][newY] = false;
                }
            }
        }
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{0,1,0,0,1,1,0},{1,0,0,0,0,0,0},{1,0,0,1,1,1,1},{0,1,0,0,0,0,0},{1,0,0,0,0,0,1},{1,0,0,1,0,0,0},{1,0,1,0,0,1,0}};
        s.shortestPathBinaryMatrix(grid);
    }


}
