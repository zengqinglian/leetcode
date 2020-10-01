package sorttheMatrixDiagonally;

import java.util.PriorityQueue;

public class Solution {
    //4ms solution, beat 90%
    public int[][] diagonalSort(int[][] mat) {
        for(int i=0; i<mat.length; i++){
            sort(i,0, mat);
        }
        for(int j=1; j<mat[0].length; j++){
            sort(0,j,mat);
        }
        return mat;
    }

    private void sort(int i, int j, int[][] mat) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int x=i, y=j; x<mat.length && y<mat[0].length; x++, y++){
            q.add(mat[x][y]);
        }
        for(int x=i, y=j; x<mat.length && y<mat[0].length; x++, y++){
            mat[x][y] = q.poll();
        }
    }
}
