package flipColumnsForMaximumNumberofEqualRows;
/*
Runtime
118 ms
Beats
16.67%
Memory
60.3 MB
Beats
5.55%
 */
public class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int res = 1;
        for (int i=0; i<matrix.length; i++) {
            int count = 1;
            for (int j=i+1; j<matrix.length; j++){
                int val = matrix[i][0] ^ matrix[j][0];
                boolean targetRow = true;
                for(int x=1; x<matrix[0].length; x++) {
                    int newVal = matrix[i][x] ^ matrix[j][x];
                    if (val != newVal) {
                        targetRow = false;
                        break;
                    }
                }
                if (targetRow) {
                    count++;
                }
            }
            res = Math.max(res, count);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int[][] matrix = {{1,0,1,1,1,1},{1,1,1,1,1,1}};
        s.maxEqualRowsAfterFlips(matrix);
    }
}
