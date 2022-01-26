package minimumOperationstoMakeArrayEqual;
/*
Runtime: 1 ms, faster than 69.26% of Java online submissions for Minimum Operations to Make Array Equal.
Memory Usage: 36 MB, less than 66.56% of Java online submissions for Minimum Operations to Make Array Equal.
 */
public class Solution {
  public int minOperations(int n) {
    int mid = (1 + (2*n-1)) /2;
    int loop = n / 2;
    int res = 0;
    for(int i= 1; i<=mid; i+=2) {
      res+=(mid - i);
    }
    return res;
  }
}
