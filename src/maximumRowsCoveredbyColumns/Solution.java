package maximumRowsCoveredbyColumns;
/*
6 ms
Beats
34.52%
Analyze Complexity
Memory
43.16 MB
Beats 16.67%
 */
public class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        if (numSelect == matrix[0].length) {
            return matrix.length;
        }
        int[] bitValue = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                bitValue[i] = (bitValue[i] * 2) + matrix[i][j];
            }
        }
        int maxloop = 0;
        for (int i = matrix[0].length-1; i >= matrix[0].length - numSelect -1; i--) {
            maxloop = maxloop + (int)Math.pow(2,i);
        }
        int res = 0;
        for (int i=0; i< maxloop; i++ ) {
            if (numberOfOnes(i, numSelect)) {
                int val = 0;
                for (int j=0; j < bitValue.length; j++) {
                    if (bitValue[j] == 0) {
                        val++;
                    }else if ((bitValue[j] | i) <= i ) {
                        val++;
                    }
                }
                res = Math.max(res, val);
            }
        }
        return res;
    }

    private boolean numberOfOnes (int v, int numSelect) {
        String s = Integer.toBinaryString(v);
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
            if (cnt > numSelect) {
                return false;
            }
        }
        return cnt == numSelect;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maximumRows(new int[][]{{1,0,0,0,0,0,0},{0,1,0,1,1,1,1},{0,0,0,1,0,0,1}}, 5);
    }
}
