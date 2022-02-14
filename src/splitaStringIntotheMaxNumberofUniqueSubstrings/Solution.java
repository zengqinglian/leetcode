package splitaStringIntotheMaxNumberofUniqueSubstrings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
/*
Runtime: 279 ms, faster than 5.07% of Java online submissions for Split a String Into the Max Number of Unique Substrings.
Memory Usage: 85.1 MB, less than 8.40% of Java online submissions for Split a String Into the Max Number of Unique Substrings.
 */
public class Solution {
  public int maxUniqueSplit(String s) {
    Queue<Node> q = new LinkedList<>();
    for(int i=0;i<s.length(); i++) {
      if(q.isEmpty()) {
        Node case1 = new Node();
        case1.sb.append(s.charAt(i));
        q.add(case1);
        Node case2 = new Node();
        case2.set.add(String.valueOf(s.charAt(i)));
        q.add(case2);
      }else{
        int size = q.size();
        for(int j=0; j<size; j++) {
          Node cur = q.poll();
          String newString = cur.sb.toString() + s.charAt(i);
          if(!cur.set.contains(newString)) {
            Node newNode = new Node();
            newNode.set.addAll(cur.set);
            newNode.set.add(newString);
            q.add(newNode);
          }
          cur.sb.append(s.charAt(i));
          q.add(cur);
        }
      }
    }
    int max = 1;
    while(!q.isEmpty()) {
      Node cur = q.poll();
      if(cur.sb.length()==0) {
        max = Math.max(max, cur.set.size());
      }
    }
    return max;
  }

  private static class Node {
    private StringBuilder sb = new StringBuilder();
    private Set<String> set = new HashSet<>();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.maxUniqueSplit("ab");
  }
}
