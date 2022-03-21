package detonateTheMaximumBombs;

import java.util.ArrayList;
import java.util.List;
/*
Runtime: 147 ms, faster than 61.56% of Java online submissions for Detonate the Maximum Bombs.
Memory Usage: 53.4 MB, less than 48.94% of Java online submissions for Detonate the Maximum Bombs.
 */
public class Solution {
  public int maximumDetonation(int[][] bombs) {
    List<Integer>[] bombsAffected = new List[bombs.length];
    for(int i = 0; i<bombs.length; i++) {
      for(int j=i+1; j<bombs.length; j++) {
        double distance = Math.sqrt(Math.pow(bombs[i][0]-bombs[j][0],2) + Math.pow(bombs[i][1]-bombs[j][1],2));
        if(distance <= bombs[i][2]) {
          if(bombsAffected[i] == null) {
            bombsAffected[i] = new ArrayList<>();
          }
          bombsAffected[i].add(j);
        }
        if(distance <= bombs[j][2]) {
          if(bombsAffected[j] == null) {
            bombsAffected[j] = new ArrayList<>();
          }
          bombsAffected[j].add(i);
        }
      }
    }
    int res = 0;
    for(int i=0; i<bombsAffected.length ; i++) {
      boolean[] visited = new boolean[bombs.length];
      visited[i] = true;
      res = Math.max(res,findTotal(i, bombsAffected, visited));
    }
    return res;
  }

  private int findTotal(int i, List<Integer>[] bombsAffected, boolean[] visited) {
    if(bombsAffected[i] == null) {
      return 1;
    }
    int total = 1;
    for(int idx : bombsAffected[i]) {
      if(!visited[idx]) {
        visited[idx] = true;
        total+=(findTotal(idx, bombsAffected, visited));
      }
    }
    return total;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] bombs = {{4,4,3},{4,4,3}};
    s.maximumDetonation(bombs);
  }
}
