package fallingSquares;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  // 95ms solution, beat 30%
  public List<Integer> fallingSquares(int[][] positions) {
    List<Integer> result = new ArrayList<>();
    List<int[]> existing = new ArrayList<>();
    int index = 0;
    int currentMax = 0;
    while (index < positions.length) {
      int max = 0;
      int startIndex = positions[index][0];
      int endIndex = positions[index][0] + positions[index][1];
      for (int[] r : existing) {
        if (endIndex <= r[0] || startIndex >= r[1]) {
          continue;
        } else {
          max = Math.max(max, r[2]);
        }
      }
      int[] newR = new int[3];
      newR[0] = startIndex;
      newR[1] = endIndex;
      newR[2] = max + positions[index][1];
      existing.add(newR);
      index++;
      currentMax = Math.max(currentMax, newR[2]);
      result.add(currentMax);

    }
    return result;
  }
}
