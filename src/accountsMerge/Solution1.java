package accountsMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution1 {
  // improvement 260ms solution - beat only 15%
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, List<Set<String>>> custEmailMap = new HashMap<>();
    Set<String> emailRecorded = new HashSet<>();

    for (int i = 0; i < accounts.size(); i++) {
      List<String> cur = accounts.get(i);
      String name = cur.get(0);

      List<Set<String>> curList = new LinkedList<>();
      if (custEmailMap.containsKey(name)) {
        curList = custEmailMap.get(name);
      } else {
        custEmailMap.put(name, curList);
      }

      SortedSet<String> newSet = new TreeSet<>();
      for (int j = 1; j < cur.size(); j++) {
        String email = cur.get(j);
        if (emailRecorded.contains(email)) {
          Iterator<Set<String>> ita = curList.iterator();
          while (ita.hasNext()) {
            Set<String> oldSet = ita.next();
            if (oldSet.contains(email)) {
              newSet.addAll(oldSet);
              ita.remove();
              break;
            }
          }
        } else {
          emailRecorded.add(email);
          newSet.add(email);
        }
      }
      curList.add(newSet);
    }

    List<List<String>> result = new ArrayList<>();
    for (String name : custEmailMap.keySet()) {
      for (Set<String> set : custEmailMap.get(name)) {
        List<String> li = new ArrayList<>();
        li.add(name);
        li.addAll(set);
        result.add(li);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    String[][] accounts =
        { {"Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co"},
            {"Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co"},
            {"Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co"},
            {"Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co"},
            {"Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co"}};
    Solution1 s = new Solution1();
    List<List<String>> parm = new ArrayList<>();
    for (String[] account : accounts) {
      parm.add(Arrays.asList(account));
    }
    s.accountsMerge(parm);
  }
}
