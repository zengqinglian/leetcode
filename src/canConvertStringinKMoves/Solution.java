package canConvertStringinKMoves;
/*
Runtime: 19 ms, faster than 60.64% of Java online submissions for Can Convert String in K Moves.
Memory Usage: 52 MB, less than 24.47% of Java online submissions for Can Convert String in K Moves.
 */
public class Solution {
  public boolean canConvertString(String s, String t, int k) {
    if(t.length()!=s.length()){
      return false;
    }
    int[] arr = new int[26];

    for(int i=0; i<s.length(); i++){
      char charS = s.charAt(i);
      char charT = t.charAt(i);
      int diff = 0;
      if(charS<=charT) {
        diff = charT - charS;
      }else {
        diff = charT - charS + 26;
      }
      if(arr[diff] > 0 ) {
        diff = arr[diff] + 26;
        arr[diff%26] = diff;
      }else{
        arr[diff] = diff;
      }

      if(diff>k){
        return false;
      }
    }
    return true;
  }
}
