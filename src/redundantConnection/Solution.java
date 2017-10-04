package redundantConnection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  // slow solution, beat only 5%
  public int[] findRedundantConnection(int[][] edges) {
    List<Set<Integer>> links = new ArrayList<>();
    for (int[] edge : edges) {
      if (links.isEmpty()) {
        Set<Integer> set = new HashSet<>();
        set.add(edge[0]);
        set.add(edge[1]);
        links.add(set);
      } else {
        Set<Integer> set1 = null;
        Set<Integer> set2 = null;
        for (Set<Integer> set : links) {
          if (set.contains(edge[0])) {
            set1 = set;
          }
          if (set.contains(edge[1])) {
            set2 = set;
          }
        }
        if (set1 == null && set2 == null) {
          Set<Integer> set = new HashSet<>();
          set.add(edge[0]);
          set.add(edge[1]);
          links.add(set);
        } else if (set1 != null && set2 != null) {
          if (set1 == set2) {
            return edge;
          } else {
            links.remove(set2);
            set1.addAll(set2);
          }
        } else {
          if (set1 != null) {
            set1.add(edge[0]);
            set1.add(edge[1]);
          } else {
            set2.add(edge[0]);
            set2.add(edge[1]);
          }
        }
      }
    }

    return null;

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] edges =
        { {3, 7}, {1, 4}, {2, 8}, {1, 6}, {7, 9}, {6, 10}, {1, 7}, {2, 3}, {8, 9}, {5, 9}};
    s.findRedundantConnection(edges);
  }
}
