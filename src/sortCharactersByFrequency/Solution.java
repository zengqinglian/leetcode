package sortCharactersByFrequency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 50ms solution - 50% average speed
    public String frequencySort(String s) {
        final Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Character>() {

            @Override
            public int compare(Character o1, Character o2) {
                if (map.get(o1) > map.get(o2)) {
                    return -1;
                } else if (map.get(o1) < map.get(o2)) {
                    return 1;
                } else {
                    return 0;
                }
            }
            
        });

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            for (int i = 1; i <= map.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.frequencySort("tree");
    }
}
