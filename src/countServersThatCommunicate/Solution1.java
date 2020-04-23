package countServersThatCommunicate;

public class Solution1 {
    //3ms solution, meet avg speed.
    public int countServers(int[][] grid) {
        int[] countsX = new int[grid.length];
        int[] countsY = new int[grid[0].length];
        for(int i=0; i<grid.length; i++) {
            int total = 0 ;
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] ==1){
                    total++;
                }
            }
            countsX[i] = total;
        }

        for(int j=0; j<grid[0].length; j++) {
            int total = 0 ;
            for (int i = 0; i < grid.length; i++) {
                if(grid[i][j] ==1){
                    total++;
                }
            }
            countsY[j] = total;
        }

        int res = 0;
        for(int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && (countsX[i]>1 || countsY[j]>1)){
                    res++;
                }
            }
        }
        return res;
    }
}
