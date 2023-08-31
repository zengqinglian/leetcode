package maximalSquare;
/*
Time Limit Exceeded. failed 77/78
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for (int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if (matrix[i][j]=='1') {
                    int loop = Math.min(m, n);
                    int area = 1;
                    res = Math.max(area, res);
                    for (int x = i;x<loop; x++ ) {
                        for(int y = j; y<loop; y++) {
                            if (matrix[x][y] == '0') {
                                loop = y;
                                break;
                            }else{
                                area = Math.min(x-i+1, y-j+1) * Math.min(x-i+1, y-j+1);
                                res = Math.max(res, area);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] matrix = {{'1','1','1','1','1'},{'0','1','1','1','1'},{'1','1','1','1','1'},{'1','1','1','1','1'}};
        //char[][] matrix = {{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'0','1','1','1','1','0','0','0'}};
        s.maximalSquare(matrix);
    }
}
