package firstUniqueCharacterinaString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1 {
    // beat 35%
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        if (s.length() == 1) {
            return 0;
        }

        Set<Character> charSet = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charSet.add(c)) {
                map.put(c, i);
            } else {
                map.remove(c);
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

        return result;

    }
}
