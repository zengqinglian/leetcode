package remove9;

public class Solution {
  // my solution only beat 15%
  private static int[] b = new int[10];
  static {
    b[1] = 1;
    for (int i = 2; i <= 9; i++) {
      b[i] = b[i - 1] * 8 + (int) Math.pow(10, i - 1) + b[i - 1];
    }
  }

  public int newInteger(int n) {
    int num = n;
    int extra = 0;
    int newExtra = getExtra(num + extra, b);
    while (newExtra != extra) {
      extra = newExtra;
      newExtra = getExtra(num + extra, b);
    }
    return (num + extra) % 10 == 9 ? num + extra - 1 : num + extra;
  }

  private int getExtra(int n, int[] base) {
    String s = String.valueOf(n);
    int total = 0;
    int index = 0;
    for (char c : s.toCharArray()) {
      int diff = c - '0';
      if (diff == 9) {
        StringBuilder sb = new StringBuilder();
        for (int i = index + 1; i < s.toCharArray().length; i++) {
          sb.append(s.charAt(i));
        }
        if (sb.toString().isEmpty()) {
          total += 1;
        } else {
          total += Integer.valueOf(sb.toString()) + 1;
        }
      }
      total += diff * base[s.length() - index - 1];
      index++;
    }
    return total;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.newInteger(43254332);
  }
}
