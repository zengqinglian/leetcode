package smallestSubsequenceOfDistinctCharacters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {
    // overtime solution - failed on
    // "abaabbbabaababbabbaabbaaaaaaaaaabbaabbaabbababbbba"
    public String smallestSubsequence(String text) {
	Set<Character> set = new HashSet<>();
	for (char c : text.toCharArray()) {
	    set.add(c);
	}

	int total = set.size();
	String res = null;
	String cur = "";
	List<String> allCases = new ArrayList<>();
	allCases.add(cur);
	Set<Character> cntSet = new HashSet<>();
	for (int i = 0; i < text.length(); i++) {
	    char c = text.charAt(i);
	    if (cntSet.add(c)) {
		for (int j = 0; j < allCases.size(); j++) {
		    String str = allCases.get(j);
		    String newStr = str + c;
		    allCases.set(j, newStr);
		    if (newStr.length() == total) {
			if (res == null) {
			    res = newStr;
			} else {
			    if (res.compareTo(newStr) > 0) {
				res = newStr;
			    }
			}
		    }
		}
	    } else {
		List<String> newCases = new ArrayList<>();
		for (String str : allCases) {
		    int idx = str.indexOf(c);
		    if (idx < str.length() - 1) {
			String newstr = str.substring(0, idx) + str.substring(idx + 1) + c;
			newCases.add(newstr);
			if (newstr.length() == total) {
			    if (res == null) {
				res = newstr;
			    } else {
				if (res.compareTo(newstr) > 0) {
				    res = newstr;
				}
			    }
			}
		    }
		}
		allCases.addAll(newCases);
	    }
	}
	return res;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.smallestSubsequence("abaabbbabaababbabbaabbaaaaaaaaaabbaabbaabbababbbba");
    }
}
