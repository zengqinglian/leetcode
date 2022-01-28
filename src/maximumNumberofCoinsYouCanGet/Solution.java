package maximumNumberofCoinsYouCanGet;

import java.util.Arrays;
/*
Runtime: 37 ms, faster than 42.06% of Java online submissions for Maximum Number of Coins You Can Get.
Memory Usage: 68.8 MB, less than 51.30% of Java online submissions for Maximum Number of Coins You Can Get.
 */
public class Solution {
  public int maxCoins(int[] piles) {
    Arrays.sort(piles);
    int n = piles.length / 3;
    int res = 0;
    for(int i=1; i<=n; i++) {
      res+=(piles[piles.length - i * 2]);
    }
    return res;
  }
}
