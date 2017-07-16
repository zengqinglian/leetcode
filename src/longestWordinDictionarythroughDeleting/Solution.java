package longestWordinDictionarythroughDeleting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
  public String findLongestWord(String s, List<String> d) {
    Collections.sort(d, new Comparator<String>() {

      @Override
      public int compare(String o1, String o2) {
        int length = o2.length() - o1.length();
        if (length != 0) {
          return length;
        } else {
          return o1.compareTo(o2);
        }
      }

    });

    for (String str : d) {
      if (containAfterDelete(s, str)) {
        return str;
      }
    }

    return "";

  }

  private boolean containAfterDelete(String s, String d) {
    int indexS = 0;
    int indexD = 0;

    while (indexD < d.length()) {
      char c = d.charAt(indexD);
      int newIndexS = s.indexOf(c, indexS);
      if (newIndexS >= 0) {
        indexS = newIndexS + 1;
      } else {
        return false;
      }
      indexD++;
    }

    return true;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<String> d = new ArrayList<>();
    // ["ale","apple","monkey","plea"]
    d.add("ale");
    d.add("apple");
    d.add("monkey");
    d.add("plea");
    d.add("ba");
    d.add("ab");
    s.findLongestWord("abpcplea", d);
  }


}
