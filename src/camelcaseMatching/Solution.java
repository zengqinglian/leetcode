package camelcaseMatching;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 0ms solution , beat 90%
    public List<Boolean> camelMatch(String[] queries, String pattern) {
	List<Boolean> res = new ArrayList<>();

	for (String query : queries) {
	    res.add(getResult(query, pattern));
	}
	return res;
    }

    private boolean getResult(String query, String pattern) {
	int query_Index = 0;
	int pattern_Index = 0;
	while (query_Index < query.length() && pattern_Index < pattern.length()) {
	    char patternChar = pattern.charAt(pattern_Index);
	    if (patternChar >= 'a' && patternChar <= 'z') {
		int indexOfQuery = query.indexOf(patternChar, query_Index);
		if (indexOfQuery < 0) {
		    return false;
		} else {
		    query_Index = indexOfQuery + 1;
		}
	    } else {
		boolean found = false;
		for(int i=query_Index ; i<query.length(); i++) {
		    char queryChar = query.charAt(i);
		    if(queryChar >='A' && queryChar<='Z'  ) {
			if (queryChar != patternChar) {
			    return false;
			} else {
			    found = true;
			    query_Index = i + 1;
			    break;
			}
		    }
		}
		if (!found) {
		    return false;
		}
	    }
	    pattern_Index++;
	}
	if (pattern_Index < pattern.length()) {
	    return false;
	}
	for (int i = query_Index; i < query.length(); i++) {
	    char c = query.charAt(i);
	    if (c >= 'A' && c <= 'Z') {
		return false;
	    }
	}

	return true;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack", "FooBarTestetA" };
	s.camelMatch(queries, "FoBaT");
    }
}
