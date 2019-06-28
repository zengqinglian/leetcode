package letterTilePossibilities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    // 40ms solution , beat only 15%
    public int numTilePossibilities(String tiles) {
	Map<Character, Integer> map = new HashMap<>();
	for (char c : tiles.toCharArray()) {
	    Integer v = map.get(c);
	    if (v == null) {
		map.put(c, 1);
	    } else {
		map.put(c, v + 1);
	    }
	}

	Queue<Map<Character, Integer>> q = new LinkedList<>();
	for (char c : map.keySet()) {
	    Map<Character, Integer> m = new HashMap<>();
	    m.put(c, 1);
	    q.offer(m);
	}

	int total = 0;
	while (!q.isEmpty()) {
	    int size = q.size();
	    total += size;
	    for (int i = 0; i < size; i++) {
		Map<Character, Integer> bench = q.poll();
		for (Character key : map.keySet()) {
		    int v = map.get(key);
		    if (!bench.containsKey(key)) {
			Map<Character, Integer> newMap = new HashMap<>(bench);
			newMap.put(key, 1);
			q.offer(newMap);
		    } else if (v > bench.get(key)) {
			Map<Character, Integer> newMap = new HashMap<>(bench);
			newMap.put(key, bench.get(key) + 1);
			q.offer(newMap);
		    }
		}
	    }

	}
	return total;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.numTilePossibilities("AAB");
    }
}
