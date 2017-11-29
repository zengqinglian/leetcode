package numberofAtoms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
  // 24ms solution beat 10%
  public String countOfAtoms(String formula) {
    LinkedList<Character> q = new LinkedList<>();
    TreeMap<String, Integer> map = new TreeMap<>();
    Map<Integer, Map<String, Integer>> tempMap = new HashMap<>();
    int index = 0;
    int level = 0;
    while (index < formula.length()) {
      char c = formula.charAt(index);
      if (c == ')') {
        int number = 0;
        while (index + 1 < formula.length() && formula.charAt(index + 1) >= '0'
            && formula.charAt(index + 1) <= '9') {
          number = 10 * number + Integer.valueOf(String.valueOf(formula.charAt(index + 1)));
          index++;
        }
        index++;
        if (number == 0) {
          number = 1;
        }
        StringBuilder sb = new StringBuilder();
        while (q.peekLast() != '(') {
          sb.append(q.pollLast());
        }
        updateTempMap(sb.reverse().toString(), tempMap, number, level);
        q.pollLast();
        level--;
      } else {
        q.add(c);
        index++;
        if (c == '(') {
          level++;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
      sb.append(q.pollFirst());
    }
    updateTempMap(sb.toString(), tempMap, 1, 0);
    merge(map, tempMap);

    StringBuilder res = new StringBuilder();
    for (String key : map.keySet()) {
      if (map.get(key) > 1) {
        res.append(key + map.get(key));
      } else {
        res.append(key);
      }
    }

    return res.toString();
  }

  private void merge(TreeMap<String, Integer> map, Map<Integer, Map<String, Integer>> tempMap) {
    for (int key : tempMap.keySet()) {
      for (String subKey : tempMap.get(key).keySet()) {
        if (map.containsKey(subKey)) {
          map.put(subKey, map.get(subKey) + tempMap.get(key).get(subKey));
        } else {
          map.put(subKey, tempMap.get(key).get(subKey));
        }
      }
    }
  }

  private void updateTempMap(String string, Map<Integer, Map<String, Integer>> tempMap, int number,
      int level) {
    LinkedList<Character> q = new LinkedList<>();
    int index = 0;

    if (!tempMap.containsKey(level + 1)) {
      Map<String, Integer> map = new HashMap<>();
      tempMap.put(level + 1, map);
    }

    if (!tempMap.containsKey(level)) {
      Map<String, Integer> map = new HashMap<>();
      tempMap.put(level, map);
    }
    while (index < string.length()) {
      char c = string.charAt(index);
      if ((c >= 'A' && c <= 'Z')) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
          char chr = q.pollFirst();
          if (chr >= '0' && chr <= '9') {
            num = num * 10 + Integer.valueOf(String.valueOf(chr));
          } else {
            sb.append(chr);
          }
        }
        if (num == 0) {
          num = 1;
        }
        if (sb.length() > 0) {

          if (tempMap.get(level + 1) != null && tempMap.get(level + 1).containsKey(sb.toString())) {
            tempMap.get(level + 1).put(sb.toString(),
                num + tempMap.get(level + 1).get(sb.toString()));
          } else if (tempMap.get(level + 1) != null) {
            tempMap.get(level + 1).put(sb.toString(), num);
          }
        }

      }
      q.add(c);
      index++;
    }

    int num = 0;
    StringBuilder sb = new StringBuilder();
    while (!q.isEmpty()) {
      char chr = q.pollFirst();
      if (chr >= '0' && chr <= '9') {
        num = num * 10 + Integer.valueOf(String.valueOf(chr));
      } else {
        sb.append(chr);
      }
    }
    if (num == 0) {
      num = 1;
    }
    if (sb.length() > 0) {
      if (tempMap.get(level + 1) != null && tempMap.get(level + 1).containsKey(sb.toString())) {
        tempMap.get(level + 1).put(sb.toString(), num + tempMap.get(level + 1).get(sb.toString()));
      } else if (tempMap.get(level + 1) != null) {
        tempMap.get(level + 1).put(sb.toString(), num);
      }
    }

    for (String key : tempMap.get(level + 1).keySet()) {
      tempMap.get(level + 1).put(key, tempMap.get(level + 1).get(key) * number);
    }

    for (String key : tempMap.get(level + 1).keySet()) {
      if (tempMap.get(level).containsKey(key)) {
        tempMap.get(level).put(key, tempMap.get(level).get(key) + tempMap.get(level + 1).get(key));
      } else {
        tempMap.get(level).put(key, tempMap.get(level + 1).get(key));
      }
    }

    tempMap.remove(level + 1);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.countOfAtoms("((H2)2(HO)3)2");
  }
}
