package accountsMerge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {
  // Some one's DSU 150ms solution
  /*
   * Intuition
   * 
   * As in Approach #1, our problem comes down to finding the connected components of a graph. This
   * is a natural fit for a Disjoint Set Union (DSU) structure.
   * 
   * Algorithm
   * 
   * As in Approach #1, draw edges between emails if they occur in the same account. For easier
   * interoperability between our DSU template, we will map each email to some integer index by
   * using emailToID. Then, dsu.find(email) will tell us a unique id representing what component
   * that email is in.
   * 
   * For more information on DSU, please look at Approach #2 in the article here. For brevity, the
   * solutions showcased below do not use union-by-rank.
   */
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    DSU dsu = new DSU();
    Map<String, String> emailToName = new HashMap();
    Map<String, Integer> emailToID = new HashMap();
    int id = 0;
    for (List<String> account : accounts) {
      String name = "";
      for (String email : account) {
        if (name == "") {
          name = email;
          continue;
        }
        emailToName.put(email, name);
        if (!emailToID.containsKey(email)) {
          emailToID.put(email, id++);
        }
        dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
      }
    }

    Map<Integer, List<String>> ans = new HashMap();
    for (String email : emailToName.keySet()) {
      int index = dsu.find(emailToID.get(email));
      ans.computeIfAbsent(index, x -> new ArrayList()).add(email);
    }
    for (List<String> component : ans.values()) {
      Collections.sort(component);
      component.add(0, emailToName.get(component.get(0)));
    }
    return new ArrayList(ans.values());
  }
}


class DSU {
  int[] parent;

  public DSU() {
    parent = new int[10001];
    for (int i = 0; i <= 10000; ++i)
      parent[i] = i;
  }

  public int find(int x) {
    if (parent[x] != x)
      parent[x] = find(parent[x]);
    return parent[x];
  }

  public void union(int x, int y) {
    parent[find(x)] = find(y);
  }
}
