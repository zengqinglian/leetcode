package countSquareSubmatricesWithAllOnes;

public class Solution1 {
    //someone's accept solution
    public int countSquares(int[][] matrix) {
        //大正方形由一个一个小正方形组成
        int res=0;
        int tmp = 1000000;
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                //判断周边
                if(matrix[i][j] == 1 && j-1>=0 && i-1>=0  ){
                    if(matrix[i-1][j] >= 1 && matrix[i-1][j-1] >= 1 && matrix[i][j-1] >= 1){
                        tmp = Math.min(matrix[i-1][j], matrix[i-1][j-1]);
                        tmp = Math.min(tmp, matrix[i][j-1]);
                        matrix[i][j] += tmp;
                    }
                }
                res += matrix[i][j];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        s.countSquares(matrix);
    }
}
