package smallestGoodBase;

public class Solution {
  // make use of geometric progression fomula a1 = 1
  // time over limit
  public String smallestGoodBase(String n) {
    long l = Long.valueOf(n);
    long minBase = l - 1;
    for (long i = 2L; i < l / 2L; i++) {
      if ((l - 1L) % i == 0L) {
        long div = (l - 1L) / i;

        if (checkBase(l - div, i)) {
          return String.valueOf(i);
        }

        if (checkBase(l - i, div)) {
          minBase = div;
        }
      }
    }

    return String.valueOf(minBase);
  }

  private boolean checkBase(long l, long div) {
    long result = -1;
    long i = 2;
    while (result < l) {
      result = (long) Math.pow(div, i);
      if (result == l) {
        return true;
      }
      i++;
    }
    return false;
  }
}
