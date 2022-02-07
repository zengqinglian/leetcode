package countUnhappyFriends;
/*
Runtime: 3 ms, faster than 84.77% of Java online submissions for Count Unhappy Friends.
Memory Usage: 63.1 MB, less than 38.58% of Java online submissions for Count Unhappy Friends.
 */
public class Solution {
  public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
    int res = 0 ;
    int[] pair_Array = new int[500];
    for(int[] pair : pairs) {
      pair_Array[pair[0]] = pair[1];
      pair_Array[pair[1]] = pair[0];
    }
    for(int[] pair : pairs) {
      int[] preferencesLeft = preferences[pair[0]];
      int idxLeft = 0;
      while(idxLeft < preferencesLeft.length && pair[1] != preferencesLeft[idxLeft]) {
        int u = preferencesLeft[idxLeft];
        int v = pair_Array[u];
        int[] v_preference = preferences[u];
        int v_preference_idx = 0;
        boolean needBreak = false;
        while(v_preference_idx < v_preference.length) {
          if(v_preference[v_preference_idx] == v) {
            break;
          }
          if(v_preference[v_preference_idx] == pair[0]) {
            res++;
            needBreak = true;
            break;
          }
          v_preference_idx++;
        }
        if(needBreak) {
          break;
        }
        idxLeft++;
      }

      int[] preferencesRight = preferences[pair[1]];
      int idxRight = 0;
      while(idxRight < preferencesRight.length && pair[0] != preferencesRight[idxRight]) {
        int u = preferencesRight[idxRight];
        int v = pair_Array[u];
        int[] v_preference = preferences[u];
        int v_preference_idx = 0;
        boolean needBreak = false;
        while(v_preference_idx < v_preference.length) {
          if(v_preference[v_preference_idx] == v) {
            break;
          }
          if(v_preference[v_preference_idx] == pair[1]) {
            needBreak = true;
            res++;
            break;
          }
          v_preference_idx++;
        }
        if(needBreak) {
          break;
        }
        idxRight++;
      }

    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] preferences = {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
    int[][] pairs = {{0,1},{2,3}};
    s.unhappyFriends(4, preferences, pairs);
  }
}
