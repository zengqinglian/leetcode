package maximumNonNegativeProductinaMatrix;
/*
Runtime: 1138 ms, faster than 5.52% of Java online submissions for Maximum Non Negative Product in a Matrix.
Memory Usage: 41.9 MB, less than 19.02% of Java online submissions for Maximum Non Negative Product in a Matrix.
 */
public class Solution {
  int[] moveX = {0,1};
  int[] moveY = {1,0};
  public int maxProductPath(int[][] grid) {
    long res = getMax(grid, 0,0, 0);
    if(res>=0) {
      return (int)(res % 1_000_000_007L);
    }
    return -1;
  }

  private long getMax(int[][] grid, int x, int y, int minusCount) {

    if(x==grid.length-1 && y == grid[0].length-1) {
      return (long)grid[x][y];
    }
    if(grid[x][y]==0){
       return 0L;
    }
    if(grid[x][y]<0){
      minusCount++;
    }
    boolean checkMax = false;
    long checkValue;
    if(minusCount%2==0){
      checkMax = true;
      checkValue= Long.MIN_VALUE;
    }else{
      checkValue= Long.MAX_VALUE;
    }

    for(int i=0; i<2; i++) {
      int newX = x + moveX[i];
      int newY = y + moveY[i];
      if(newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length ) {
        long newValue = getMax(grid, newX, newY, minusCount);
        if(checkMax) {
          checkValue = Math.max(checkValue, newValue);
        } else {
          checkValue = Math.min(checkValue, newValue);
        }
      }
    }
    return (checkValue * grid[x][y])  ;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //int[][] grid = {{-1,-2,-3},{-2,-3,-3},{-3,-3,-2}};
    int[][] grid = {{-1,-4,2},{4,3,-1},{2,-4,4},{1,-1,-4}};
    s.maxProductPath(grid);
  }
}
