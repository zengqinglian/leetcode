package freedomTrail;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  // Dp solution - 50ms beat 85%
  public int findRotateSteps(String ring, String key) {
    // indexes per char
    List<Integer>[] indexPerChar = new List[26];
    int val = 0;
    for (char c : ring.toCharArray()) {
      int index = c - 'a';
      if (indexPerChar[index] == null) {
        List<Integer> li = new ArrayList<>();
        li.add(val);
        indexPerChar[index] = li;
      } else {
        indexPerChar[index].add(val);
      }
      val++;
    }

    List<int[]>[] dp = new List[key.length()];

    dp[0] = new ArrayList<>();
    List<Integer> firstList = indexPerChar[key.charAt(0) - 'a'];
    for (int i : firstList) {
      int[] r = new int[2];
      r[0] = getStep(0, i, ring.length()) + 1;
      r[1] = i;
      dp[0].add(r);
    }

    for (int i = 1; i < key.length(); i++) {
      dp[i] = new ArrayList<>();
      List<Integer> newIndex = indexPerChar[key.charAt(i) - 'a'];
      for (int idx : newIndex) {
        int minSum = Integer.MAX_VALUE;
        int nIdx = -1;
        for (int[] preRes : dp[i - 1]) {
          int newSum = preRes[0] + getStep(preRes[1], idx, ring.length()) + 1;
          if (newSum < minSum) {
            minSum = newSum;
            nIdx = idx;
          }
        }
        int[] r = new int[2];
        r[0] = minSum;
        r[1] = nIdx;
        dp[i].add(r);
      }
    }

    List<int[]> last = dp[key.length() - 1];

    int min = Integer.MAX_VALUE;
    for (int[] i : last) {
      if (i[0] < min) {
        min = i[0];
      }
    }

    return min;

  }

  private int getStep(int startIndex, int endIndex, int length) {
    return Math.min(Math.abs(endIndex - startIndex), endIndex - startIndex >= 0 ? length
        - (endIndex - startIndex) : endIndex - startIndex + length);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.findRotateSteps("edcba", "abcde");
  }
}
