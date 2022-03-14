package minimumDeletionstoMakeCharacterFrequenciesUnique;

import java.util.HashSet;
import java.util.Set;

/*
Runtime: 13 ms, faster than 81.49% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
Memory Usage: 54.8 MB, less than 36.64% of Java online submissions for Minimum Deletions to Make Character Frequencies Unique.
 */
public class Solution {
  public int minDeletions(String s) {
    int[] countArray = new int[26];
    for(char c : s.toCharArray()) {
      countArray[c-'a']++;
    }
    Set<Integer> set = new HashSet<>();
    int cnt = 0;
    for(int v : countArray) {
      while(v>0 && set.contains(v)) {
        v--;
        cnt++;
      }
      set.add(v);
    }
    return cnt;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.minDeletions("aabbcc");
  }
}
