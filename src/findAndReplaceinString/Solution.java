package findAndReplaceinString;

import java.util.TreeMap;

public class Solution {
    // 7ms solution meet avg speed
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

	TreeMap<Integer, Integer> treeMap = new TreeMap<>();
	for (int i = 0; i < indexes.length; i++) {
	    treeMap.put(indexes[i], i);
	}

	StringBuilder sb = new StringBuilder();
	int cur = 0;
	for (int key : treeMap.keySet()) {
	    int i = treeMap.get(key);
	    if (cur != indexes[i]) {
		sb.append(S.substring(cur, indexes[i]));
	    }
	    String source = sources[i];
	    int length = source.length();
	    String s = S.substring(indexes[i], indexes[i] + length);
	    if (s.equals(source)) {
		sb.append(targets[i]);
	    } else {
		sb.append(s);
	    }
	    cur = indexes[i] + length;
	}

	if (cur < S.length()) {
	    sb.append(S.substring(cur));
	}

	return sb.toString();
    }

    public static void main(String[] args) {
	/*
	 * "reauaqyxle" [4,6,2] ["aq","yxl","au"] ["c","dh","ev"]
	 */
	Solution s = new Solution();
	int[] indexes = { 4, 6, 2 };
	String[] sources = { "a", "cd" };
	String[] targets = { "eee", "ffff" };
	s.findReplaceString("reauaqyxle", indexes, sources, targets);
    }
}
