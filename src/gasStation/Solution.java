package gasStation;

public class Solution {
  // 1ms solution, beat 60% o(N)
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int length = gas.length;
    int index = -1;
    int total = 0;
    int subTotal = 0;
    for (int i = 0; i < length; i++) {
      int d = gas[i] - cost[i];
      total += d;
      subTotal += d;
      if (subTotal < 0) {
        index = -1;
        subTotal = 0;
      } else {
        if (d >= 0 && index == -1) {
          index = i;
        }
      }
    }
    if (total >= 0) {
      return index;
    } else {
      return -1;
    }
  }

}
