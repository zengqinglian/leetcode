package findDuplicateFileinSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  // 56ms solution meet avg speed.
  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : paths) {
      updateMap(map, str);
    }
    List<List<String>> result = new ArrayList<>();
    for (List<String> li : map.values()) {
      if (li.size() > 1)
        result.add(li);
    }
    return result;
  }

  private void updateMap(Map<String, List<String>> map, String str) {
    String[] dirs = str.split(" ");
    String root = dirs[0];
    for (int i = 1; i < dirs.length; i++) {
      int index = dirs[i].indexOf("(");
      String content = dirs[i].substring(index + 1, dirs[i].length() - 1);
      if (map.containsKey(content)) {
        map.get(content).add(root + "/" + dirs[i].substring(0, index));
      } else {
        List<String> li = new ArrayList<>();
        li.add(root + "/" + dirs[i].substring(0, index));
        map.put(content, li);
      }
    }
  }
}
