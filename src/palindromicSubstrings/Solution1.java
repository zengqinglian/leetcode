package palindromicSubstrings;

public class Solution1 {
  // do not insert ' ' element. slower solution since extra loop inside for
  public int countSubstrings(String s) {

    if (s == null || s.length() == 0) {
      return 0;
    }

    if (s.length() == 1) {
      return 1;
    }

    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      result++;
      if (i - 1 >= 0) {
        if (s.charAt(i - 1) == s.charAt(i)) {
          result++;
          int count = 1;
          while (i - 1 - count >= 0 && i + count <= s.length() - 1
              && s.charAt(i - 1 - count) == s.charAt(i + count)) {
            result++;
            count++;
          }
        }
        int count = 1;
        while (i - count >= 0 && i + count <= s.length() - 1
            && s.charAt(i - count) == s.charAt(i + count)) {
          result++;
          count++;
        }
      }
    }

    return result;

  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    s.countSubstrings("aaa");
  }
}
