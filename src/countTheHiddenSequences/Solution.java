package countTheHiddenSequences;
/*
Runtime: 6 ms, faster than 54.15% of Java online submissions for Count the Hidden Sequences.
Memory Usage: 109.1 MB, less than 49.82% of Java online submissions for Count the Hidden Sequences.
 */
public class Solution {
  public int numberOfArrays(int[] differences, int lower, int upper) {
    int rangelow = lower;
    int rangeHigh = upper;

    for (int i = differences.length - 1; i >= 0; i--) {
      rangelow = Math.max(lower, rangelow - differences[i]);
      rangeHigh = Math.min(upper, rangeHigh - differences[i]);
      if (rangelow > rangeHigh) {
        return 0;
      }
    }
    return rangeHigh-rangelow+1;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] differences = {4,-7,2};
    s.numberOfArrays(differences, 3,6);
  }
}
