package longestPalindromebyConcatenatingTwoLetterWords;

import java.util.HashMap;
import java.util.Map;
/*
Runtime: 155 ms, faster than 49.91% of Java online submissions for Longest Palindrome by Concatenating Two Letter Words.
Memory Usage: 124.6 MB, less than 35.90% of Java online submissions for Longest Palindrome by Concatenating Two Letter Words.
 */
public class Solution {
  public int longestPalindrome(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    int res = 0;
    for(String word : words) {
      char[] charArray = {word.charAt(1), word.charAt(0)};
      String searchKey = String.valueOf(charArray);
      Integer cnt = map.get(searchKey);
      if(cnt!=null && cnt > 0) {
        res+=4;
        cnt--;
        if(cnt==0) {
          map.remove(searchKey);
        }else{
          map.put(searchKey,cnt);
        }
      }else{
        Integer newCount = map.get(word);
        if(newCount == null) {
          map.put(word, 1);
        }else{
          map.put(word, newCount+1);
        }
      }
    }
    for(String key : map.keySet()) {
      if(key.charAt(0) == key.charAt(1)) {
        return res+2;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String[] words = {"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"};
    s.longestPalindrome(words);
  }
}
