package largestSubmatrixWithRearrangements;

import java.util.Arrays;

public class Solution {
    //someone's 6ms solution
    public int largestSubmatrix(int[][] matrix) {
        int h = matrix.length;
        int l = matrix[0].length;
        for(int j=0; j<l; j++){
            for(int i=1; i<h; i++){
                if(matrix[i][j]==1)
                    matrix[i][j] = matrix[i-1][j] +1;
            }
        }
        int ans = 0;
        for(int i=0; i<h; i++){
            Arrays.sort(matrix[i]);
            for(int j=l-1; j>=0; j--){
                ans = Math.max(ans, matrix[i][j] * (l-j));
            }
        }
        return ans;
    }
}
