package numberofMatchingSubsequences;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 71ms solution - beat 70%
    public int numMatchingSubseq(String S, String[] words) {
	List<Integer>[] tracker = new List[26];

	for (int i = 0; i < S.length(); i++) {
	    char c = S.charAt(i);
	    if (tracker[c - 'a'] == null) {
		List<Integer> li = new ArrayList<>();
		li.add(i);
		tracker[c - 'a'] = li;
	    } else {
		tracker[c - 'a'].add(i);
	    }
	}

	int result = 0;
	for (String s : words) {
	    int[] indexes = new int[26];
	    boolean isSub = true;
	    int curindex = -1;
	    for (int i=0; i<s.length(); i++) {
		char c = s.charAt(i);
		if (tracker[c - 'a'] == null) {
		    isSub = false;
		    break;
		} else {
		    List<Integer> li = tracker[c - 'a'];
		    int startIndex = indexes[c - 'a'];
		    boolean found = false;
		    for (int j = startIndex; j < li.size(); j++) {
			if (li.get(j) >= i && li.get(j) > curindex) {
			    indexes[c - 'a'] = j + 1;
			    found = true;
			    curindex = li.get(j);
			    break;
			}
		    }
		    if (!found) {
			isSub = false;
			break;
		    }
		}
	    }

	    if (isSub) {
		result++;
	    }
	}

	return result;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	String[] words = { "a", "bb", "acd", "ace" };
	s.numMatchingSubseq(
		"abcde",
		words);
    }
}
