package spiralMatrix;

import java.util.ArrayList;
import java.util.List;
/*
Runtime
0 ms
Beats
100%
Memory
40.3 MB
Beats
90.81%
 */
public class Solution {

    int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int i=0;
        int j=-1;
        while(true){
            boolean noMoves = true;
            for(int x=0; x<4; x++) {
                int nextI = i + moves[x][0];
                int nextJ = j + moves[x][1];
                while (nextI>=0 && nextI < matrix.length && nextJ>=0 && nextJ<matrix[0].length
                        && matrix[nextI][nextJ]!=1000) {
                    noMoves = false;
                    res.add(matrix[nextI][nextJ]);
                    matrix[nextI][nextJ] = 1000;
                    i = nextI;
                    j= nextJ;
                    nextI = nextI + moves[x][0];
                    nextJ = nextJ + moves[x][1];
                }
            }
            if (noMoves) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        s.spiralOrder(matrix);
    }
}
