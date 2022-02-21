package splitTwoStringstoMakePalindrome;
/*
Runtime: 8 ms, faster than 42.52% of Java online submissions for Split Two Strings to Make Palindrome.
Memory Usage: 62.3 MB, less than 14.96% of Java online submissions for Split Two Strings to Make Palindrome.
 */
public class Solution {
  public boolean checkPalindromeFormation(String a, String b) {
    return check(a,b) || check(b,a);
  }
  public boolean check(String a, String b) {
    int i=0;
    int j= a.length()-1;
    boolean res1 = true;
    boolean res2 = true;
    boolean res3 = true;
    boolean res4 = true;
    while(i<j) {
      if(res1) {
        if (a.charAt(i) != a.charAt(j)) {
          res1 = false;
        }
      }
      if(res2) {
        if (a.charAt(i) != b.charAt(j)) {
          res2 = false;
        }
      }
      if(!res2 && res3) {
        if(b.charAt(i)!=b.charAt(j)) {
          res3 = false;
        }
      }
      if(!res2 && res4) {
        if(a.charAt(i)!=a.charAt(j)) {
          res4 = false;
        }
      }
      if(!res1 && !res2 && !res3 && !res4){
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
