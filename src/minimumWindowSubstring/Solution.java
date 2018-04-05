package minimumWindowSubstring;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    // 36-38ms solution - beat 45%
    // use int[] replace Map.
    public String minWindow(String s, String t) {
	if (t.length() == 1) {
	    if (s.indexOf(t.charAt(0)) >= 0) {
		return t;
	    } else {
		return "";
	    }
	}

	LinkedList<Integer> deque = new LinkedList<>();
	int min = Integer.MAX_VALUE;
	String result = "";
	Map<Character, Integer> tMap = new HashMap<>();
	int letterCount = t.length();
	for (int i = 0; i < t.length(); i++) {
	    char c = t.charAt(i);
	    if (!tMap.containsKey(c)) {
		tMap.put(c, 1);
	    }else {
		tMap.put(c, tMap.get(c) + 1);
	    }
	}
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (tMap.containsKey(c)) {
		tMap.put(c, tMap.get(c) - 1);
		deque.push(i);
		if (tMap.get(c) >= 0) {
		    letterCount--;
		    int head = -1;
		    while (letterCount == 0) {
			head = deque.pollLast();
			char chr = s.charAt(head);
			tMap.put(chr, tMap.get(chr) + 1);
			if (tMap.get(chr) > 0) {
			    letterCount++;
			}
		    }
		    if (head >= 0) {
			int tail = deque.peekFirst();
			if (tail - head + 1 < min) {
			    min = tail - head + 1;
			    result = s.substring(head, tail + 1);
			}
		    }
		}
	    }
	}
	return result;
    }

    public static void main(String[] args) {
	Solution sl = new Solution();
	String s = "ADOBECODEBANCA";
	String t = "AABC";
	sl.minWindow(s, t);
    }
}
