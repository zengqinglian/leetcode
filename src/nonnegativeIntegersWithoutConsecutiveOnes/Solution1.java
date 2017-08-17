package nonnegativeIntegersWithoutConsecutiveOnes;

public class Solution1 {
  // fixed memory but over time limit
  public int findIntegers(int num) {
    if (num == 0) {
      return 1;
    }
    if (num == 1) {
      return 2;
    }

    byte[] mask = {1, 2, 4, 8, 16, 32, 64};
    byte[] b = new byte[(num + 1) / 7 + 1];

    b[0] = 7;

    for (int i = 2; i <= (num + 1) / 2; i++) {
      int index = i / 7;
      int bit = i % 7;

      if (i * 2 > num) {
        break;
      }

      if (i % 2 == 1 && (b[index] & mask[bit]) != 0) {
        int newIndex = (2 * i) / 7;
        int newBit = (2 * i) % 7;
        b[newIndex] = (byte) (b[newIndex] | mask[newBit]);
      } else if ((b[index] & mask[bit]) != 0) {
        int newIndex = (2 * i) / 7;
        int newBit = (2 * i) % 7;
        b[newIndex] = (byte) (b[newIndex] | mask[newBit]);
        if (2 * i + 1 <= num) {
          newIndex = (2 * i + 1) / 7;
          newBit = (2 * i + 1) % 7;
          b[newIndex] = (byte) (b[newIndex] | mask[newBit]);
        }
      }
    }
    int count = 0;
    for (byte bi : b) {
      while (bi > 0) {
        if (bi % 2 == 1) {
          count++;
        }
        bi = (byte) (bi / 2);
      }
    }

    return count;
  }
}
