package smallestGoodBase;

import java.math.BigInteger;

public class Solution2 {
  // binary search to reduce the total time
  // n(1 - b) > 1 - pow(b, n), then b is too big
  // n(1 - b) < 1 - pow(b, n), then b is too small.
  public String smallestGoodBase(String n) {
    long l = Long.parseLong(n);
    long res = 0;
    for (int k = 60; k >= 2; k--) {
      long s = 2, e = l;
      while (s < e) {
        long m = s + (e - s) / 2;

        BigInteger left = BigInteger.valueOf(m);
        left = left.pow(k).subtract(BigInteger.ONE);
        BigInteger right =
            BigInteger.valueOf(l).multiply(BigInteger.valueOf(m).subtract(BigInteger.ONE));
        int cmr = left.compareTo(right);
        if (cmr == 0) {
          res = m;
          break;
        } else if (cmr < 0) {
          s = m + 1;
        } else {
          e = m;
        }
      }

      if (res != 0)
        break;
    }

    return "" + res;
  }

}
