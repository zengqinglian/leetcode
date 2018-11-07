package findandReplacePattern;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 3ms solution, beat 90%
    public List<String> findAndReplacePattern(String[] words, String pattern) {
	List<Integer>[] pList = new List[26];

	for (int i = 0; i < pattern.length(); i++) {
	    char c = pattern.charAt(i);
	    if (pList[c - 'a'] == null) {
		pList[c - 'a'] = new ArrayList<>();
	    }
	    pList[c - 'a'].add(i);
	}

	List<String> result = new ArrayList<>();
	for (String word : words) {
	    if (check(word, pList, pattern)) {
		result.add(word);
	    }
	}
	return result;
    }

    private boolean check(String word, List<Integer>[] pList1, String pattern) {
	for (List<Integer> li : pList1) {
	    if (li != null && li.size() > 1) {
		char c = word.charAt(li.get(0));
		for (int i = 1; i < li.size(); i++) {
		    if (c != word.charAt(li.get(i))) {
			return false;
		    }
		}
	    }
	}
	List<Integer>[] pList = new List[26];
	for (int i = 0; i < word.length(); i++) {
	    char c = word.charAt(i);
	    if (pList[c - 'a'] == null) {
		pList[c - 'a'] = new ArrayList<>();
	    }
	    pList[c - 'a'].add(i);
	    if (pattern.charAt(pList[c - 'a'].get(0)) != pattern.charAt(i)) {
		return false;
	    }
	}

	return true;
    }

}
