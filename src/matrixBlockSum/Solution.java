package matrixBlockSum;

public class Solution {
    //3ms solution , beat 90%
    public int[][] matrixBlockSum(int[][] mat, int K) {
        for(int i=1; i<mat.length; i++){
            mat[i][0] = mat[i-1][0] + mat[i][0];
        }
        for(int j=1; j<mat[0].length; j++){
            mat[0][j] = mat[0][j-1] + mat[0][j];
        }
        for(int i=1; i<mat.length; i++){
            for(int j=1; j<mat[0].length; j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1] + mat[i][j] - mat[i-1][j-1];
            }
        }
        int[][] res = new int[mat.length][mat[0].length];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                int s_i = i-K <0 ? 0: i-K;
                int e_i = i+K>=mat.length ? mat.length-1 : i+K;

                int s_j = j-K <0 ? 0: j-K;
                int e_j = j+K>=mat[0].length ? mat[0].length-1 : j+K;

                res[i][j] = mat[e_i][e_j];
                if(s_i-1>=0){
                    res[i][j] = res[i][j] - mat[s_i-1][e_j];
                }
                if(s_j-1>=0){
                    res[i][j] = res[i][j] - mat[e_i][s_j-1];
                }
                if(s_i-1>=0 && s_j-1>=0){
                    res[i][j] = res[i][j] + mat[s_i-1][s_j-1];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        s.matrixBlockSum(mat, 1);
    }
}
