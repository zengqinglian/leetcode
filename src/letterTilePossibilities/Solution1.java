package letterTilePossibilities;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    // 17ms solution , meet avg
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

	int res = check(map, 0, tiles.length());
	return res;
    }

    private int check(Map<Character, Integer> map, int round, int length) {
	if (round == length) {
	    return 0;
	}
	int total = 0;
	for (char key : map.keySet()) {
	    int v = map.get(key);
	    if(v>0) {
		total += 1;
		map.put(key, v-1);
		total += check(map, round + 1, length);
		map.put(key, v);
	    }
	}   
	return total;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.numTilePossibilities("AAABBC");
    }
}
