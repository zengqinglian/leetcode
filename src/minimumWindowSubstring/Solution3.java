package minimumWindowSubstring;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
/*
24ms Beats
26.30%

Memory 45.78MB
Beats 9.01%
 */
public class Solution3 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            int v = targetMap.getOrDefault(c,0);
            targetMap.put(c, v+1);
        }
        Map<Character, Integer> sourceMap = new HashMap<>();
        Queue<Integer> startIndexQueue = new LinkedList<>();
        int minLen = Integer.MAX_VALUE;
        int resStart = -1;
        int resEnd = -1;
        char removeChar = ' ';
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!targetMap.containsKey(c)) {
                continue;
            }
            startIndexQueue.add(i);
            int v = sourceMap.getOrDefault(c,0);
            sourceMap.put(c, 1+v);
            while ( minLen == Integer.MAX_VALUE ? containAll(sourceMap, targetMap) : sourceMap.get(removeChar) >= targetMap.get(removeChar)) {
                int startIndex = startIndexQueue.poll();
                int newLen = i - startIndex +1;
                if (newLen<minLen) {
                    resStart = startIndex;
                    resEnd = i;
                    minLen = newLen;
                }
                removeChar = s.charAt(startIndex);
                sourceMap.put(removeChar, sourceMap.get(removeChar)-1);
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(resStart, resEnd+1);
    }

    private boolean containAll(Map<Character, Integer> sourceMap, Map<Character, Integer> targetMap) {
        for(char c : targetMap.keySet()) {
            if (!sourceMap.containsKey(c)) {
                return false;
            }else{
                if (sourceMap.get(c) < targetMap.get(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        s.minWindow("ADOBECODEBANC", "ABC");
    }
}
