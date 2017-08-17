package nonnegativeIntegersWithoutConsecutiveOnes;

public class Solution {
  // memory over solution
  public int findIntegers(int num) {
    byte[] b = new byte[num + 1];

    b[0] = 1;
    b[1] = 1;

    for (int i = 1; i <= (b.length - 1) / 2; i++) {
      if (i * 2 >= b.length) {
        break;
      }
      if (i % 2 == 1 && b[i] == 1) {
        b[2 * i] = 1;
      } else if (b[i] == 1) {
        b[2 * i] = 1;
        if (2 * i + 1 <= num)
          b[2 * i + 1] = 1;
      }
    }
    int count = 0;
    for (byte bi : b) {
      if (bi == 1) {
        count++;
      }
    }

    return count;

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.findIntegers(2);
  }

}
