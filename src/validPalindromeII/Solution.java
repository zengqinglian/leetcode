package validPalindromeII;

public class Solution {
  // overtime limit
  public boolean validPalindrome(String s) {

    if (s.length() == 1) {
      return true;
    }

    return valid(s, false);

  }

  private boolean valid(String s, boolean allMatch) {
    if (s.length() == 1) {
      return true;
    }

    if (s.length() == 2) {
      if (allMatch) {
        if (s.charAt(0) == s.charAt(1)) {
          return true;
        } else {
          return false;
        }
      } else {
        return true;
      }
    }

    if (allMatch) {
      if (s.charAt(0) == s.charAt(s.length() - 1)) {
        return valid(s.substring(1, s.length() - 1), allMatch);
      } else {
        return false;
      }
    } else {
      if (s.charAt(0) == s.charAt(s.length() - 1)) {
        return valid(s.substring(1, s.length() - 1), allMatch);
      } else {
        boolean res = false;
        if (s.charAt(0) == s.charAt(s.length() - 2)) {
          res = valid(s.substring(0, s.length() - 1), true);
        }
        if (s.charAt(1) == s.charAt(s.length() - 1)) {
          res = res || valid(s.substring(1, s.length()), true);
        }
        return res;
      }
    }
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    s.validPalindrome("ececabbacec");
  }
}
