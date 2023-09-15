package rottingOranges;

import java.util.LinkedList;
import java.util.Queue;
/*
Runtime
5 ms
Beats
9.55%
Memory
43.5 MB
Beats
5.36%
 */
public class Solution {
    int[] X = {1,-1,0,0};
    int[] Y = {0,0,1,-1};
    public int orangesRotting(int[][] grid) {
        int res = 0;
        int[][] count = new int[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                boolean[][] visited = new boolean[grid.length][grid[0].length];
                if (grid[i][j] == 2) {
                    int[] p = {i,j};
                    q.add(p);
                    int min = 1;
                    while(!q.isEmpty()) {
                        int size = q.size();
                        for (int x=0; x<size; x++) {
                            int[] pos = q.poll();
                            for(int m=0; m<4; m++) {
                                int newX = pos[0] + X[m];
                                int newY = pos[1] + Y[m];
                                if (newX >=0 && newX<grid.length && newY >=0 && newY <grid[0].length
                                        && !visited[newX][newY] && grid[newX][newY] ==1) {
                                    int[] newPos = {newX,newY};
                                    q.add(newPos);
                                    visited[newX][newY] = true;
                                    if (count[newX][newY]==0){
                                        count[newX][newY] = min;
                                    }else{
                                        count[newX][newY] = Math.min(count[newX][newY], min);
                                    }
                                }
                            }
                        }
                        min++;
                    }
                }
            }
        }
        for(int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (count[i][j]==0 && grid[i][j] == 1) {
                    return -1;
                }else if (grid[i][j] == 1) {
                    res = Math.max(res, count[i][j]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{2,2,2},{2,2,0},{0,2,2}};
        s.orangesRotting(grid);
    }
}
