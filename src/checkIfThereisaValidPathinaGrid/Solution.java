package checkIfThereisaValidPathinaGrid;

import java.util.LinkedList;
import java.util.Queue;

/*
Runtime: 23 ms, faster than 36.86% of Java online submissions for Check if There is a Valid Path in a Grid.
Memory Usage: 51.9 MB, less than 90.71% of Java online submissions for Check if There is a Valid Path in a Grid.
 */
public class Solution {
  public boolean hasValidPath(int[][] grid) {
    if(grid.length==1 && grid[0].length ==1){
      return true;
    }
    int[] X = {1,-1,0,0};
    int[] Y = {0,0,1,-1};

    Queue<int[]> q = new LinkedList<>();
    int[] start = {0,0};
    q.add(start);
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    visited[0][0] = true;
    while(!q.isEmpty()){
      int[] pos = q.poll();
      for(int i=0; i<4; i++){
        int newX = X[i] + pos[0];
        int newY = Y[i] + pos[1];
        int type = grid[pos[0]][pos[1]];
        int[] newpos = {newX, newY};
        if(newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length && !visited[newX][newY]){
          if(checkType(type, pos, newpos, grid)){
            if(newX==grid.length-1 && newY==grid[0].length-1){
              return true;
            }
            q.add(newpos);
            visited[newX][newY]=true;
          }
        }
      }
    }
    return false;
  }

  private boolean checkType(int type, int[] pos, int[] newpos, int[][] grid) {
    boolean res = false;
    switch (type){
      case 1: res=checkType1(pos,newpos,grid);
        break;
      case 2: res=checkType2(pos,newpos,grid);
        break;
      case 3: res=checkType3(pos,newpos,grid);
        break;
      case 4: res=checkType4(pos,newpos,grid);
        break;
      case 5: res=checkType5(pos,newpos,grid);
        break;
      case 6: res=checkType6(pos,newpos,grid);
        break;
      default:
    }
    return res;
  }

  private boolean checkType1(int[] pos, int[] newpos, int[][] grid) {
    return (newpos[1] > pos[1] && (grid[newpos[0]][newpos[1]] == 1 || grid[newpos[0]][newpos[1]] == 3 || grid[newpos[0]][newpos[1]]==5))
        || (newpos[1] < pos[1] && (grid[newpos[0]][newpos[1]] == 1 ||grid[newpos[0]][newpos[1]] == 2 || grid[newpos[0]][newpos[1]]==4));
  }

  private boolean checkType2(int[] pos, int[] newpos, int[][] grid) {
    return (newpos[0] > pos[0] && (grid[newpos[0]][newpos[1]] == 2 || grid[newpos[0]][newpos[1]] == 5 || grid[newpos[0]][newpos[1]]==6))
        || (newpos[0] < pos[0] && (grid[newpos[0]][newpos[1]] == 2 || grid[newpos[0]][newpos[1]] == 3 || grid[newpos[0]][newpos[1]]==4));
  }
  private boolean checkType3(int[] pos, int[] newpos, int[][] grid) {
    return (newpos[1] < pos[1] && (grid[newpos[0]][newpos[1]] == 2 ||grid[newpos[0]][newpos[1]]==5 ||grid[newpos[0]][newpos[1]]==6))
        || (newpos[0] > pos[0] && (grid[newpos[0]][newpos[1]] == 2 || grid[newpos[0]][newpos[1]]==5 || grid[newpos[0]][newpos[1]]==6));
  }
  private boolean checkType4(int[] pos, int[] newpos, int[][] grid) {
    return (newpos[1] > pos[1] && (grid[newpos[0]][newpos[1]] == 1 || grid[newpos[0]][newpos[1]]==3 || grid[newpos[0]][newpos[1]]==5))
        || (newpos[0] > pos[0] && (grid[newpos[0]][newpos[1]] == 2 || grid[newpos[0]][newpos[1]]==5 || grid[newpos[0]][newpos[1]]==6));
  }
  private boolean checkType5(int[] pos, int[] newpos, int[][] grid) {
    return (newpos[0] < pos[0] && (grid[newpos[0]][newpos[1]] == 2 || grid[newpos[0]][newpos[1]]==3 || grid[newpos[0]][newpos[1]]==4))
        || (newpos[1] < pos[1] && (grid[newpos[0]][newpos[1]] == 1 || grid[newpos[0]][newpos[1]]==4 || grid[newpos[0]][newpos[1]]==6));
  }
  private boolean checkType6(int[] pos, int[] newpos, int[][] grid) {
    return (newpos[1] > pos[1] && (grid[newpos[0]][newpos[1]] == 1 || grid[newpos[0]][newpos[1]]==3 || grid[newpos[0]][newpos[1]]==5))
        || (newpos[0] < pos[0] && (grid[newpos[0]][newpos[1]] == 2 || grid[newpos[0]][newpos[1]]==3 || grid[newpos[0]][newpos[1]]==4));
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] grid ={{3,4,3,4},{2,2,2,2},{6,5,6,5}};
    s.hasValidPath(grid);
  }
}
