package maximumSwap;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  // solution beat 50%
  public int maximumSwap(int num) {
    if (num <= 10) {
      return num;
    }
    int[] ds = new int[9];
    Map<Integer, Integer> indexMap = new HashMap<>();
    int startIndex = -1;
    int orig = num;

    int div = 100000000;

    for (int i = 0; i < 9; i++) {
      ds[i] = num / div;
      if (ds[i] > 0 && startIndex == -1) {
        startIndex = i;
        indexMap.put(ds[i], i);
      }
      if (startIndex != -1) {
        indexMap.put(ds[i], i);
      }
      num = num % div;
      div = div / 10;
    }

    for (int i = startIndex; i < 9; i++) {
      for (int m = 9; m > ds[i]; m--) {
        if (indexMap.containsKey(m)) {
          int index = indexMap.get(m);
          if (index > i) {
            int temp = ds[index];
            ds[index] = ds[i];
            ds[i] = temp;
            int sum = ds[0];
            for (int n = 1; n < 9; n++) {
              sum = sum * 10 + ds[n];
            }
            return sum;
          }
        }
      }
    }


    return orig;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.maximumSwap(98368);
  }
}
