package shortestCompletingWord;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  // use map solution 44ms
  public String shortestCompletingWord(String licensePlate, String[] words) {
    Map<Integer, Integer> plateMap = new HashMap<>();
    for (char c : licensePlate.toCharArray()) {
      int key = -1;
      if (c >= 'a' && c <= 'z') {
        key = c - 'a';
      } else if (c >= 'A' && c <= 'Z') {
        key = c - 'A';
      }

      if (key < 0) {
        continue;
      }
      if (plateMap.get(key) != null) {
        plateMap.put(key, plateMap.get(key) + 1);
      } else {
        plateMap.put(key, 1);
      }

    }

    String result = "0000000000000000000000000000000";
    for (String word : words) {
      Map<Integer, Integer> map = new HashMap<>(plateMap);
      for (char c : word.toCharArray()) {
        int key = -1;
        if (c >= 'a' && c <= 'z') {
          key = c - 'a';
        } else if (c >= 'A' && c <= 'Z') {
          key = c - 'A';
        }
        Integer val = map.get(key);
        if (val != null) {
          if (val == 1) {
            map.remove(key);
          } else {
            map.put(key, val - 1);
          }
        }
        if (map.isEmpty()) {
          if (result.length() > word.length()) {
            result = word;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String[] words = {"step", "steps", "stripe", "stepple"};
    s.shortestCompletingWord("1s3 PSt", words);
  }
}
