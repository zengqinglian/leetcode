package pathWithMaximumGold;

public class Solution {
    //17ms solution , meat avg speed. beat 50%

    int[] X = {0,0,1,-1};
    int[] Y = {1,-1,0,0};
    public int getMaximumGold(int[][] grid) {
        int res = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int total = 0 ;
                if(grid[i][j]>0){
                    int[] point = {i,j};
                    total += getMaxFromPos(grid, point);
                }
                res = Math.max(res, total);
            }
        }
        return res;
    }

    private int getMaxFromPos(int[][] grid, int[] point){
        int cur = grid[point[0]][point[1]];
        grid[point[0]][point[1]] = 0;
        int res = cur;
        for(int i=0; i<4; i++){
            if(point[0]+X[i]>=0 && point[0]+X[i] < grid.length && point[1]+Y[i]>=0 && point[1]+Y[i]<grid[0].length){
                if(grid[point[0]+X[i]][point[1]+Y[i]]>0){
                    int[] newPoint = {point[0]+X[i],point[1]+Y[i]};
                    res = Math.max(res, cur + getMaxFromPos(grid, newPoint));
                }
            }
        }
        grid[point[0]][point[1]] = cur;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};
        s.getMaximumGold(grid);
    }
}
