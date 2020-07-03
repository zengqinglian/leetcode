package maximumSideLength;

public class Solution1 {
    //170ms solution beat 5%
    public int maxSideLength(int[][] mat, int threshold) {
        int max = 0;
        for(int x = 0; x<mat.length; x++) {
            for (int y = 0; y < mat[0].length; y++) {
                int total = mat[x][y];
                int startX = x;
                int startY = y;
                int len = 1;
                while(total<=threshold){
                    max = Math.max(len, max);
                    startX = x + len;
                    startY = y + len;
                    if(startX < mat.length && startY < mat[0].length){
                        for(int i=startX; i>=x; i--){
                            total+=mat[i][startY];
                        }
                        for(int i=startY; i>=y; i--){
                            total+=mat[startX][i];
                        }
                        total -= mat[startX][startY];
                        len++;
                    }else{
                        max = Math.max(len, max);
                        break;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] mat = {{28,39,98,91,7,99},{79,3,17,83,9,92},{81,73,42,27,67,70},{88,30,73,99,96,89},{27,59,0,1,65,79},{42,55,48,29,86,96}};
        s.maxSideLength(mat, 24829);
    }
}
