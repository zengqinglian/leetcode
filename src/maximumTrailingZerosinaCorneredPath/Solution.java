package maximumTrailingZerosinaCorneredPath;
/*
Runtime: 409 ms, faster than 13.33% of Java online submissions for Maximum Trailing Zeros in a Cornered Path.
Memory Usage: 138.1 MB, less than 37.78% of Java online submissions for Maximum Trailing Zeros in a Cornered Path.
 */
public class Solution {
    public int maxTrailingZeros(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] count = new int[r][c][2];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                get2And5Count(grid[i][j], count[i][j]);
            }
        }

        int[][][] prefixSumRow = new int[r][c][2];
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if (j==0) {
                    prefixSumRow[i][j] =count[i][j];
                }else{
                    prefixSumRow[i][j][0] = prefixSumRow[i][j-1][0] + count[i][j][0];
                    prefixSumRow[i][j][1] = prefixSumRow[i][j-1][1] + count[i][j][1];
                }
            }
        }

        int[][][] prefixSumCol = new int[r][c][2];
        for(int j=0; j<c; j++) {
            for(int i=0; i<r; i++) {
                if (i==0) {
                    prefixSumCol[i][j] =count[i][j];
                }else{
                    prefixSumCol[i][j][0] = prefixSumCol[i-1][j][0] + count[i][j][0];
                    prefixSumCol[i][j][1] = prefixSumCol[i-1][j][1] + count[i][j][1];
                }
            }
        }

        int res = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                //top - left
                int total2 = count[i][j][0];
                int total5= count[i][j][1];
                if (j-1>=0) {
                    total2+=prefixSumRow[i][j-1][0];
                    total5+=prefixSumRow[i][j-1][1];
                }
                if (i-1>=0) {
                    total2+=prefixSumCol[i-1][j][0];
                    total5+=prefixSumCol[i-1][j][1];
                }
                res = Math.max(res, Math.min(total2, total5));

                // top - right
                total2 = count[i][j][0];
                total5= count[i][j][1];
                if (j+1<c) {
                    total2+=(prefixSumRow[i][c-1][0] - prefixSumRow[i][j][0]);
                    total5+=(prefixSumRow[i][c-1][1] - prefixSumRow[i][j][1]);
                }
                if (i-1>=0) {
                    total2+=prefixSumCol[i-1][j][0];
                    total5+=prefixSumCol[i-1][j][1];
                }
                res = Math.max(res, Math.min(total2, total5));

                // bottom -left
                total2 = count[i][j][0];
                total5= count[i][j][1];
                if (j-1>=0) {
                    total2+=prefixSumRow[i][j-1][0];
                    total5+=prefixSumRow[i][j-1][1];
                }
                if (i+1<r) {
                    total2+=(prefixSumCol[r-1][j][0] - prefixSumCol[i][j][0]);
                    total5+=(prefixSumCol[r-1][j][1] - prefixSumCol[i][j][1]);
                }
                res = Math.max(res, Math.min(total2, total5));

                //bottom - right
                total2 = count[i][j][0];
                total5= count[i][j][1];
                if (j+1<c) {
                    total2+=(prefixSumRow[i][c-1][0] - prefixSumRow[i][j][0]);
                    total5+=(prefixSumRow[i][c-1][1] - prefixSumRow[i][j][1]);
                }
                if (i+1<r) {
                    total2+=(prefixSumCol[r-1][j][0] - prefixSumCol[i][j][0]);
                    total5+=(prefixSumCol[r-1][j][1] - prefixSumCol[i][j][1]);
                }
                res = Math.max(res, Math.min(total2, total5));
            }
        }
        return res;
    }

    private void get2And5Count(int val, int[] state) {
        int cnt5 =0;
        while (val>0 && val % 5 == 0) {
            cnt5++;
            val/=5;
        }
        int cnt2 =0;
        while (val>0 && val % 2 == 0) {
            cnt2++;
            val/=2;
        }

        state[0] = cnt2;
        state[1] = cnt5;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{23,17,15,3,20},{8,1,20,27,11},{9,4,6,2,21},{40,9,1,10,6},{22,7,4,5,3}};
        s.maxTrailingZeros(grid);
    }
}
