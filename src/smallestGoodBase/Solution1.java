package smallestGoodBase;

public class Solution1 {
  // still over time limit.
  public String smallestGoodBase(String n) {
    long l = Long.valueOf(n);
    long minBase = l - 1;
    for (long i = 2L; i < Math.sqrt(l); i++) {
      if ((l - 1L) % i == 0L) {
        long div = (l - 1L) / i;

        if (checkBase(l - div, i)) {
          System.out.print(i);
          return String.valueOf(i);
        }

        if (checkBase(l - i, div)) {
          minBase = div;
        }
      }
    }
    System.out.print(minBase);
    return String.valueOf(minBase);
  }

  private boolean checkBase(long l, long b) {
    if (Math.log(l) % Math.log(b) == 0) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();

    s.smallestGoodBase("470988884881403701");
  }

}
