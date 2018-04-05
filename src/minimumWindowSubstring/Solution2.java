package minimumWindowSubstring;

import java.util.LinkedList;

public class Solution2 {
    // use int[] replace Map , improve perf to 15ms. beat 60%
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
	int[] tMap = new int[256];
	int[] cntMap = new int[256];
	int letterCount = t.length();
	for (int i = 0; i < t.length(); i++) {
	    tMap[t.charAt(i)]++;
	}
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (tMap[c]>0) {
		deque.push(i);
		cntMap[c]++;
		if (cntMap[c] <= tMap[c]) {
		    letterCount--;
		}

		int head = -1;
		while (letterCount == 0) {
		    head = deque.pollLast();
		    char chr = s.charAt(head);
		    cntMap[chr]--;
		    if (cntMap[chr] < tMap[chr]) {
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
	return result;
    }

    public static void main(String[] args) {
	Solution2 sl = new Solution2();
	String s = "ADOBECODEBANCA";
	String t = "AABC";
	sl.minWindow(s, t);
    }

}
