package smallestSubsequenceOfDistinctCharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // overtime limit solution - 14/65
    String res = null;
    public String smallestSubsequence(String text) {
	Set<Character> set = new HashSet<>();
	for (char c : text.toCharArray()) {
	    set.add(c);
	}

	int total = set.size();
	if (total == 1) {
	    return text.substring(0, 1);
	}
	
	for (int i = 0; i <= text.length() - total + 1; i++) {
	    getString(i, text, total, new HashSet<Character>(), new StringBuilder());
	}

	return res;

    }


    private void getString(int i, String text, int total, HashSet<Character> set, StringBuilder sb) {
	char c = text.charAt(i);
	if (set.add(c)) {
	    sb.append(c);
	    if (set.size() == total) {
		if (res == null) {
		    res = sb.toString();
		} else {
		    if (res.compareTo(sb.toString()) > 0) {
			res = sb.toString();
		    }
		}
	    } else {
		for (int j = i + 1; j < text.length() - total + set.size() + 1; j++) {
		    getString(j, text, total, set, sb);
		}
	    }
	    set.remove(c);
	    sb.setLength(sb.length() - 1);
	} else {
	    for (int j = i + 1; j < text.length() - total + set.size() + 1; j++) {
		getString(j, text, total, set, sb);
	    }
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.smallestSubsequence("ecbacba");

    }
}
