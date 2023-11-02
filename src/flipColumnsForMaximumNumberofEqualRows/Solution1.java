package flipColumnsForMaximumNumberofEqualRows;

import java.util.LinkedList;
import java.util.Queue;
/*
Runtime
37 ms
Beats
44.44%
Memory
55.8 MB
Beats
86.11%
 */
public class Solution1 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int res = 1;
        Queue<Integer> rowIndex = new LinkedList<>();
        for (int j = 1; j < matrix.length; j++) {
            int val = matrix[0][0] ^ matrix[j][0];
            boolean targetRow = true;
            for (int x = 1; x < matrix[0].length; x++) {
                int newVal = matrix[0][x] ^ matrix[j][x];
                if (val != newVal) {
                    targetRow = false;
                    break;
                }
            }
            if (targetRow) {
                res++;
            }else{
                rowIndex.add(j);
            }
        }
        while (rowIndex.size() > 1 && rowIndex.size() > res) {
            int count = 1;
            int size = rowIndex.size();
            int firstRowIndex = rowIndex.poll();
            for (int j=1;j<size; j++) {
                int currentIndex = rowIndex.poll();
                int val = matrix[firstRowIndex][0] ^ matrix[currentIndex][0];
                boolean targetRow = true;
                for (int x = 1; x < matrix[0].length; x++) {
                    int newVal = matrix[firstRowIndex][x] ^ matrix[currentIndex][x];
                    if (val != newVal) {
                        targetRow = false;
                        break;
                    }
                }
                if (targetRow) {
                    count++;
                }else{
                    rowIndex.add(currentIndex);
                }
            }
            res =Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] matrix = {{0,1,0,1},{1,1,1,1},{1,0,1,1},{0,0,1,1},{0,1,0,0},{1,1,0,1},{1,0,0,0},{1,0,1,1},{0,0,1,1},{1,0,1,1}};
        s.maxEqualRowsAfterFlips(matrix);
    }
}
