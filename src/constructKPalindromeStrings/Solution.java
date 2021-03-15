package constructKPalindromeStrings;
/*
Runtime: 5 ms, faster than 87.18% of Java online submissions for Construct K Palindrome Strings.
Memory Usage: 39.3 MB, less than 93.82% of Java online submissions for Construct K Palindrome Strings.
 */
public class Solution {
  public boolean canConstruct(String s, int k) {
    if(s.length() < k){
      return false;
    }
    if(s.length() == k){
      return true;
    }

    int[] letters = new int[26];
    for(char c : s.toCharArray()){
      letters[c-'a'] ++ ;
    }
    int oddsCnt = 0;
    for(int v : letters){
      if(v  % 2 ==1){
        oddsCnt++;
      }
    }
    if(oddsCnt <=k){
      return true;
    }
    return false;
  }
}
