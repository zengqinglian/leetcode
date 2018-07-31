package customSortString;

import java.util.LinkedHashMap;

public class Solution {
    // 5ms solution - beat 40%
    public String customSortString(String S, String T) {
	LinkedHashMap<Character, Integer> map = new LinkedHashMap<>(200);
	for(char c : T.toCharArray()) {
	    if (map.containsKey(c)) {
		map.put(c, map.get(c) + 1);
	    } else {
		map.put(c, 1);
	    }
	}

	StringBuilder sb = new StringBuilder();
	for (char c : S.toCharArray()) {
	    if (map.containsKey(c)) {
		for (int i = 0; i < map.get(c); i++) {
		    sb.append(c);
		}
		map.put(c, 0);
	    }
	}
	
	for (char key : map.keySet()) {
	    for (int i = 0; i < map.get(key); i++) {
		sb.append(key);
	    }
	}
	
	return sb.toString();

    }
}
