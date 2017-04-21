package longestUncommonSubsequenceII;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    // solution beat 48% 16ms
    public int findLUSlength(String[] strs) {
        if (strs.length == 0) {
            return -1;
        }

        if (strs.length == 1) {
            return strs[0].length();
        }

        Map<Integer, Map<String, Integer>> caches = new TreeMap<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {

                return -o1.compareTo(o2);
            }
        });
        for (String s : strs) {
            if (caches.containsKey(s.length())) {
                Map<String, Integer> map = caches.get(s.length());
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            } else {
                Map<String, Integer> map = new HashMap<>();
                map.put(s, 1);
                caches.put(s.length(), map);
            }
        }
        
        Set<String> set = new HashSet<>();

        for (Map<String, Integer> map : caches.values()) {
            int max = maxLength(set, map);
            if (max > 0) {
                return max;
            }
        }
        return -1;

    }

    private int maxLength(Set<String> set, Map<String, Integer> map) {

        for (String str : map.keySet()) {
            if (!isSubStr(set, str)) {
                if (map.get(str) == 1) {
                    return str.length();
                } else {
                    set.add(str);
                }
            }
        }
        return -1;
        
    }

    private boolean isSubStr(Set<String> set, String str) {
        for (String s : set) {
            if (s.length() > str.length()) {
                int i = 0;
                for (int j = 0; j < str.length(); j++) {
                    boolean found = false;
                    while (i < s.length()) {
                        if (s.charAt(i) == str.charAt(j)) {
                            i++;
                            found = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (!found) {
                        return found;
                    }
                }
                return true;
            } else if (s.length() == str.length()) {
                return s.equals(str);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = { "aabbcc", "aabbcc", "cb", "abc" };
        s.findLUSlength(strs);
    }
}
