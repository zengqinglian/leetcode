package detectCyclesin2DGrid;
/*
Runtime: 20 ms, faster than 68.04% of Java online submissions for Detect Cycles in 2D Grid.
Memory Usage: 100.3 MB, less than 56.07% of Java online submissions for Detect Cycles in 2D Grid.
 */
public class Solution {
  int[] moveX = {1,-1,0,0};
  int[] moveY ={0,0,1,-1};
  public boolean containsCycle(char[][] grid) {
    if(grid.length<=1){
      return false;
    }
    if(grid[0].length <=1) {
      return false;
    }
    int[][] visited = new int[grid.length][grid[0].length];
    for(int i=0;i<grid.length; i++){
      for(int j=0; j<grid[0].length; j++){
        if(visited[i][j] ==1) {
          continue;
        }
        visited[i][j] = 1;
        boolean res = checkCircle(grid, visited, i, j);
        if(res) {
          return res;
        }
      }
    }
    return false;
  }

  private boolean checkCircle(char[][]  grid,int[][] visited, int x, int y) {
    char currentChar = grid[x][y];
    for(int i=0; i<moveX.length; i++) {
      int newX = x + moveX[i];
      int newY = y + moveY[i];
      if(newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length && grid[newX][newY] ==currentChar) {
        if(visited[newX][newY]==0) {
          visited[newX][newY] = visited[x][y]+1;
          if(checkCircle(grid, visited, newX, newY)){
            return true;
          };
        }else {
          if(visited[x][y] - visited[newX][newY] >=3) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    char[][] grid = {{'f','c','b','d','f','a','e','e','a','c','e'},
        {'d','f','f','c','c','a','b','b','a','c','f'},
        {'e','d','d','a','d','d','d','c','f','b','e'},
        {'e','a','d','d','a','e','e','a','c','f','b'},
        {'d','c','f','a','b','c','c','d','e','c','b'},
        {'d','a','e','d','a','a','a','e','f','a','b'},
        {'d','f','e','a','f','b','c','b','d','a','e'},
        {'c','f','d','c','d','a','e','e','a','a','e'},
        {'f','b','c','e','e','b','e','b','a','a','a'},
        {'d','d','b','c','b','f','a','c','b','c','d'},
        {'e','e','c','c','e','b','e','f','b','c','d'}};
    Solution s = new Solution();
    s.containsCycle(grid);

  }
}
