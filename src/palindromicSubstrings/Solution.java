package palindromicSubstrings;

public class Solution {
  // my solution beat 60%
  public int countSubstrings(String s) {

    if (s == null || s.length() == 0) {
      return 0;
    }

    if (s.length() == 1) {
      return 1;
    }

    char[] c = new char[s.length() * 2 - 1];
    for (int i = 0; i < s.length(); i++) {
      c[2 * i] = s.charAt(i);
      if (i != s.length() - 1) {
        c[2 * i + 1] = ' ';
      }
    }

    int result = 0;

    for (int i = 0; i < c.length; i++) {
      int j;
      if (c[i] != ' ') {
        result++;
        j = 2;

      } else {
        j = 1;
      }
      while (i - j >= 0 && i + j <= c.length - 1 && c[i - j] == c[i + j]) {
        result++;
        j += 2;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.countSubstrings("abccbd");
  }
}
