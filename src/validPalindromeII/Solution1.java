package validPalindromeII;

public class Solution1 {
  // beat 50% , improved solution
  public boolean validPalindrome(String s) {
    if (s.length() == 1) {
      return true;
    }

    int i = 0;
    int j = s.length() - 1;

    while (i <= j) {
      if (s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        boolean res = false;
        if (s.charAt(i + 1) == s.charAt(j)) {
          res = isPalindrome(s.substring(i + 1, j + 1));
        }

        if (s.charAt(i) == s.charAt(j - 1)) {
          res = res || isPalindrome(s.substring(i, j));
        }
        return res;
      }
    }
    return true;
  }

  private boolean isPalindrome(String str) {
    if (str.length() == 1) {
      return true;
    }
    int i = 0;
    int j = str.length() - 1;

    while (i <= j) {
      if (str.charAt(i) == str.charAt(j)) {
        i++;
        j--;
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    s.validPalindrome("ececabbacec");
  }
}
