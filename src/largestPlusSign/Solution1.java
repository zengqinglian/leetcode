package largestPlusSign;
/*
Runtime
152ms
Beats
21.71%
Analyze Complexity
Memory
46.24 MB
Beats
66.36%

 */
public class Solution1 {
    int[] X = {1,-1, 0, 0};
    int[] Y = {0, 0, 1, -1};
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] matrix = new int[n][n];
        for(int[] mine : mines) {
            matrix[mine[0]][mine[1]] = 1;
        }
        int max = 0;
        for (int i=max; i<n-max; i++){
            for (int j=max; j<n-max; j++){
                if (matrix[i][j] == 0) {
                    max = Math.max(1,max);
                    int times = 1;
                    boolean stop = false;
                    while(true){
                        for (int m=0; m<4; m++) {
                            int newX = i + X[m] * times;
                            int newY = j + Y[m] * times;
                            if (newX >=0 && newX<n && newY >=0 && newY<n ){
                                if (matrix[newX][newY] == 1){
                                    stop = true;
                                    break;
                                }
                            }else{
                                stop = true;
                                break;
                            }
                        }
                        if (stop) {
                            max = Math.max(max, times);
                            break;
                        }else{
                            times++;
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mines = new int[][]{{4,2}};
        solution.orderOfLargestPlusSign(5, mines);
    }
}
