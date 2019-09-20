package longestStringChain;

import java.util.ArrayList;
import java.util.List;

//10ms solution , beat only 90%
public class Solution {
    public int longestStrChain(String[] words) {
	List<int[]>[] lengthMap = new List[1001];
	int max_len = 0;
	int min_len = 1000;
	for (int i = 0; i < words.length; i++) {
	    int len = words[i].length();
	    max_len = Math.max(max_len, len);
	    min_len = Math.min(min_len, len);
	    if (lengthMap[len] == null) {
		lengthMap[len] = new ArrayList<>();
	    }
	    int[] node = { i, 1 };
	    lengthMap[len].add(node);
	}

	int res = 1;
	for (int i = min_len + 1; i <= max_len; i++) {
	    if (lengthMap[i] == null) {
		continue;
	    }

	    if (lengthMap[i - 1] == null) {
		continue;
	    }

	    for (int[] newNode : lengthMap[i]) {
		String cur = words[newNode[0]];
		int max = 1;
		for (int[] preNode : lengthMap[i - 1]) {
		    String pre = words[preNode[0]];
		    if (checkword(pre, cur)) {
			max = preNode[1] + 1;
		    }
		}
		newNode[1] = max;
		res = Math.max(res, max);
	    }
	}

	return res;

    }

    private boolean checkword(String pre, String cur) {
	for (int i = 0; i < pre.length(); i++) {
	    if (pre.charAt(i) != cur.charAt(i) && pre.charAt(i) != cur.charAt(i + 1)) {
		return false;
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	String[] words = { "c", "cd", "ba", "bca", "bda", "bdca" };
	Solution s = new Solution();
	s.longestStrChain(words);
    }
}
