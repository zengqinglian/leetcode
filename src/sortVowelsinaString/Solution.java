package sortVowelsinaString;

import java.util.*;
/*
Runtime
57 ms
Beats
45.85%
Memory
47.2 MB
Beats
33.41%
 */
public class Solution {
    Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A','E','I','O','U'));
    public String sortVowels(String s) {
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for(char c : s.toCharArray()) {
            if (allVowels.contains(c)){
                Integer cnt = treeMap.get(c);
                if (cnt == null) {
                    treeMap.put(c, 1);
                }else{
                    treeMap.put(c, cnt+1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (allVowels.contains(c)) {
                Map.Entry<Character, Integer> entry = treeMap.firstEntry();
                if (entry.getValue() == 1) {
                    treeMap.remove(entry.getKey());
                }else{
                    treeMap.put(entry.getKey(),entry.getValue()-1);
                }
                sb.append(entry.getKey());
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.sortVowels("lEetcOde");
    }
}
