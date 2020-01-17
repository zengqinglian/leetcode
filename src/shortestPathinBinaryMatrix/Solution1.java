package shortestPathinBinaryMatrix;

import java.util.LinkedList;
import java.util.Queue;

//30ms solution , beat 30%
public class Solution1 {
    int[] X = {1,1,0,-1,1,-1,-1,0};
    int[] Y = {1,0,1,1,-1, 0,-1,-1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1){
            return -1;
        }
        if(0==grid.length-1){
            return 1;
        }
        boolean [][] visited = new boolean[grid.length][grid.length];
        Queue<int[]> q = new LinkedList<>();
        int[] start = {0,0};
        q.add(start);
        int cnt = 1;
        visited[0][0] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] p = q.poll();
                for(int j=0;j<8;j++){
                    int newX = p[0] + X[j];
                    int newY = p[1] + Y[j];
                    if(newX>=0 && newX<grid.length && newY>=0 && newY<grid.length){
                        if(!visited[newX][newY] && grid[newX][newY]==0) {
                            if(newX == grid.length-1 && newY == grid.length-1){
                                return cnt+1;
                            }
                            visited[newX][newY] = true;
                            int[] newP = {newX, newY};
                            q.add(newP);
                        }
                    }
                }
            }
            cnt++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        //int[][] grid = {{0,1,0,0,1,1,0},{1,0,0,0,0,0,0},{1,0,0,1,1,1,1},{0,1,0,0,0,0,0},{1,0,0,0,0,0,1},{1,0,0,1,0,0,0},{1,0,1,0,0,1,0}};
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        s.shortestPathBinaryMatrix(grid);
    }

}
