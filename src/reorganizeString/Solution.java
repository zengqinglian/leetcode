package reorganizeString;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 26ms solution beat 50%
    public String reorganizeString(String S) {
	if (S.length() <= 1) {
	    return S;
	}

	char maxChar = S.charAt(0);
	int max = 1;
	Map<Character, Integer> map = new HashMap<>();
	for (char c : S.toCharArray()) {
	    if (map.containsKey(c)) {
		map.put(c, map.get(c) + 1);
	    } else {
		map.put(c, 1);
	    }
	    if (map.get(c) > max) {
		maxChar = c;
		max = map.get(c);
	    }
	}

	if (max > (S.length() + 1) / 2) {
	    return "";
	}

	char[] result = new char[S.length()];

	for (int i = 0; i < S.length(); i += 2) {
	    if (map.get(maxChar) > 0) {
		result[i] = maxChar;
		map.put(maxChar, map.get(maxChar) - 1);
	    } else {
		for (char key : map.keySet()) {
		    if (map.get(key) > 0) {
			result[i] = key;
			map.put(key, map.get(key) - 1);
			break;
		    }
		}
	    }
	}

	for (int i = 1; i < S.length(); i += 2) {
	    for (char key : map.keySet()) {
		if (map.get(key) > 0) {
		    result[i] = key;
		    map.put(key, map.get(key) - 1);
		    break;
		}
	    }
	}

	return String.valueOf(result);

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.reorganizeString("bbbbayobq");
    }

}
