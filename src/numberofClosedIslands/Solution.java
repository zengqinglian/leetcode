package numberofClosedIslands;

import java.util.LinkedList;
import java.util.Queue;

//5m solution, beat 15%
public class Solution {
    int[] X = {1,-1,0,0};
    int[] Y = {0,0,1,-1};
    public int closedIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int res = 0;
        for(int i=1; i<grid.length-1; i++){
            for(int j=1; j<grid[0].length-1; j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    int[] p = {i, j};
                    q.add(p);
                    visited[i][j] = true;
                    boolean count = true;
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int s=0; s<4; s++){
                            int newI = cur[0]+X[s];
                            int newJ = cur[1]+Y[s];

                            if(newI>=0 && newI<grid.length && newJ>=0 && newJ<grid[0].length && !visited[newI][newJ] && grid[newI][newJ]==0){
                                if(newI==0 || newI==grid.length-1){
                                    count = false;
                                    continue;
                                }
                                if(newJ == 0 || newJ == grid[0].length-1){
                                    count = false;
                                    continue;
                                }
                                int[] newPos = {newI, newJ};
                                q.add(newPos);
                                visited[newI][newJ] = true;
                            }
                        }
                    }
                    if(count){
                        res++;
                    }
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[][] grid =  {{0,0,1,1,0,1,0,0,1,0},{1,1,0,1,1,0,1,1,1,0},{1,0,1,1,1,0,0,1,1,0},{0,1,1,0,0,0,0,1,0,1},{0,0,0,0,0,0,1,1,1,0},{0,1,0,1,0,1,0,1,1,1},{1,0,1,0,1,1,0,0,0,1},{1,1,1,1,1,1,0,0,0,0},{1,1,1,0,0,1,0,1,0,1},{1,1,1,0,1,1,0,1,1,0}};
        Solution s = new Solution();
        s.closedIsland(grid);
    }
}
