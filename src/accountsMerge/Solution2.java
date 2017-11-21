package accountsMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Solution2 {
  // someone's Depth-First Search solution 150ms beat 35%
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, String> emailToName = new HashMap<>();
    Map<String, ArrayList<String>> graph = new HashMap<>();
    for (List<String> account : accounts) {
      String name = "";
      for (String email : account) {
        if (name == "") {
          name = email;
          continue;
        }
        graph.computeIfAbsent(email, x -> new ArrayList<String>()).add(account.get(1));
        graph.computeIfAbsent(account.get(1), x -> new ArrayList<String>()).add(email);
        emailToName.put(email, name);
      }
    }

    Set<String> seen = new HashSet<>();
    List<List<String>> ans = new ArrayList<>();
    for (String email : graph.keySet()) {
      if (!seen.contains(email)) {
        seen.add(email);
        Stack<String> stack = new Stack<>();
        stack.push(email);
        List<String> component = new ArrayList<>();
        while (!stack.empty()) {
          String node = stack.pop();
          component.add(node);
          for (String nei : graph.get(node)) {
            if (!seen.contains(nei)) {
              seen.add(nei);
              stack.push(nei);
            }
          }
        }
        Collections.sort(component);
        component.add(0, emailToName.get(email));
        ans.add(component);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String[][] accounts =
        { {"Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co"},
            {"Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co"},
            {"Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co"},
            {"Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co"},
            {"Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co"}};
    Solution2 s = new Solution2();
    List<List<String>> parm = new ArrayList<>();
    for (String[] account : accounts) {
      parm.add(Arrays.asList(account));
    }
    s.accountsMerge(parm);
  }
}
