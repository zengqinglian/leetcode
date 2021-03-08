package sortIntegersbyThePowerValue;

import java.util.Arrays;

/*
Runtime: 46 ms, faster than 76.53% of Java online submissions for Sort Integers by The Power Value.
Memory Usage: 37.7 MB, less than 97.08% of Java online submissions for Sort Integers by The Power Value.
 */
public class Solution {
  int[] calVals = new int[1000000];
  public int getKth(int lo, int hi, int k) {
    Integer[] values = new Integer[hi-lo+1];
    for(int i=lo; i<=hi ; i++){
      values[i-lo] = i;
    }
    Arrays.sort(values, (a,b)->{
      int res = calc(a) - calc(b);
      if(res==0){
        return Integer.compare(a,b);
      }
      return res;
    });
    return values[k-1];
  }

  private int calc(Integer a) {
    if(a == 1) {
      return 0;
    }
    if(a % 2 ==0){
      int res = 0;
      if(calVals[a/2]==0){
        res = 1 + calc(a/2);
      }else{
        res=1+calVals[a/2];
      }
      calVals[a] = res;
      return res;
    }else{
      int res = 0;
      if(calVals[3 * a + 1]==0){
        res = 1 + calc(3 * a + 1);
      }else{
        res = 1+calVals[3 * a + 1];
      }
      calVals[a] = res;
      return res;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.getKth(1,1000,777);
  }
}
