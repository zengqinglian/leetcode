package firstUniqueCharacterinaString;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // beat 30%
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        if (s.length() == 1) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, Integer.MAX_VALUE);
            } else {
                map.put(c, i);
            }
        }
        if (map.isEmpty()) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int i : map.values()) {
            if (result > i) {
                result = i;
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
