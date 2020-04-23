package countServersThatCommunicate;

import java.util.LinkedList;
import java.util.Queue;

//60ms solution, beat only 5%
public class Solution {
    int[] X = {1,-1,0,0};
    int[] Y = {0,0,1,-1};

    public int countServers(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int cnt = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int num = 1;
                    int[] pos = {i,j};
                    q.add(pos);
                    visited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] p = q.poll();
                        for(int n=0;n<4;n++) {
                            for (int time = 1; time <= Math.max(grid.length,grid[0].length); time++) {
                                int newX = X[n] * time + p[0];
                                int newY = Y[n] * time + p[1];
                                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY] && grid[newX][newY] == 1) {
                                    int[] newPos = {newX, newY};
                                    q.add(newPos);
                                    visited[newX][newY] = true;
                                    num++;
                                }
                            }
                        }
                    }
                    if (num > 1) {
                        cnt+= num;
                    }
                }
            }
        }
        return cnt;
    }
}
