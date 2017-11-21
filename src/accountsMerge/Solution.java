package accountsMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
  // 340ms solution beat only 10%
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, Set<Integer>> mailToCust = new HashMap<>();
    Map<String, Set<Set<Integer>>> nameAndEmailGroup = new HashMap<>();

    for (int j = 0; j < accounts.size(); j++) {
      String name = accounts.get(j).get(0);
      Set<Integer> newGroup = new HashSet<>();
      newGroup.add(j);
      for (int i = 1; i < accounts.get(j).size(); i++) {
        String email = accounts.get(j).get(i);
        if (mailToCust.containsKey(email)) {
          Set<Integer> removedItems = mailToCust.get(email);
          mailToCust.get(email).add(j);
          if (nameAndEmailGroup.get(name) != null) {
            Iterator<Set<Integer>> ita = nameAndEmailGroup.get(name).iterator();
            while (ita.hasNext()) {
              Set<Integer> set = ita.next();
              boolean needRemove = false;
              for (Integer ig : removedItems) {
                if (set.contains(ig)) {
                  needRemove = true;
                  break;
                }
              }
              if (needRemove) {
                newGroup.addAll(set);
                ita.remove();
              }
            }
          }
        } else {
          Set<Integer> set = new HashSet<>();
          set.add(j);
          mailToCust.put(email, set);
        }
      }
      if (nameAndEmailGroup.containsKey(name)) {
        nameAndEmailGroup.get(name).add(newGroup);
      } else {
        Set<Set<Integer>> set = new HashSet<>();
        set.add(newGroup);
        nameAndEmailGroup.put(name, set);
      }
    }

    List<List<String>> result = new ArrayList<>();

    for (String key : nameAndEmailGroup.keySet()) {
      for (Set<Integer> set : nameAndEmailGroup.get(key)) {
        List<String> sortedList = generateSortedResult(set, key, accounts);
        result.add(sortedList);
      }
    }

    return result;
  }

  private List<String> generateSortedResult(Set<Integer> set, String key,
      List<List<String>> accounts) {
    List<String> list = new ArrayList<>();
    list.add(key);
    SortedSet<String> sortSet = new TreeSet<>();
    for (Integer i : set) {
      sortSet.addAll(accounts.get(i).subList(1, accounts.get(i).size()));
    }
    list.addAll(sortSet);
    return list;
  }

  public static void main(String[] args) {
    String[][] accounts =
        { {"Alex", "Alex5@m.co", "Alex4@m.co", "Alex0@m.co"},
            {"Ethan", "Ethan3@m.co", "Ethan3@m.co", "Ethan0@m.co"},
            {"Kevin", "Kevin4@m.co", "Kevin2@m.co", "Kevin2@m.co"},
            {"Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe2@m.co"},
            {"Gabe", "Gabe3@m.co", "Gabe4@m.co", "Gabe2@m.co"}};
    Solution s = new Solution();
    List<List<String>> parm = new ArrayList<>();
    for (String[] account : accounts) {
      parm.add(Arrays.asList(account));
    }
    s.accountsMerge(parm);
  }
}
