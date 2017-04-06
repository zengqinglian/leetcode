package wordBreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    // overtime
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Character, Set<String>> map = new HashMap<>();
        for (String str : wordDict) {
            if (!map.containsKey(str.charAt(0))) {
                Set<String> set = new HashSet<>();
                set.add(str);
                map.put(str.charAt(0), set);
            } else {
                map.get(str.charAt(0)).add(str);
            }
        }
        boolean result = canBreak(s, 0, map);
        System.out.println(result);
        return result;
    }

    private boolean canBreak(String s, int index, Map<Character, Set<String>> map) {
        if (index > s.length() - 1) {
            return false;
        }
        boolean findTrue = false;
        if (map.containsKey(s.charAt(index))) {
            for (String str : map.get(s.charAt(index))) {
                if (s.length() >= str.length() && s.length() >= index + str.length()
                        && s.substring(index, index + str.length()).equals(str)) {
                    if (index + str.length() == s.length()) {
                        return true;
                    } else {
                        findTrue = findTrue || canBreak(s, index + str.length(), map);
                    }
                }
            }
        }

        return findTrue;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordDict.add("co");
        
        s.wordBreak("leetcocoecode", wordDict);
    }
}
