package splitaStringIntotheMaxNumberofUniqueSubstrings;

import java.util.HashSet;
import java.util.Set;
/*
Runtime: 63 ms, faster than 59.20% of Java online submissions for Split a String Into the Max Number of Unique Substrings.
Memory Usage: 68.1 MB, less than 28.53% of Java online submissions for Split a String Into the Max Number of Unique Substrings.
 */
public class Solution1 {
  public int maxUniqueSplit(String s) {
    int res= findMax(s, new HashSet<>());
    return res;
  }

  private int findMax (String s, Set<String> set) {
    if(s.length()==1) {
      if(set.contains(s)){
        return -1;
      }else{
        return set.size()+1;
      }
    }

    int res=-1;
    for(int i=0; i<s.length(); i++) {
      String sub1 = s.substring(0,i+1);
      String sub2 = "";
      if(i+1<s.length()) {
        sub2 = s.substring(i+1);
      }
      if(!set.contains(sub1)) {
        set.add(sub1);
        if(!sub2.isEmpty()){
          res = Math.max(res,findMax(sub2,set));
        }else{
          res = Math.max(res,set.size());
        }
        set.remove(sub1);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    s.maxUniqueSplit("abbaba");
  }
}
