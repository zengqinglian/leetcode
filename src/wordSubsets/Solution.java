package wordSubsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 25ms solution , beat 85%
    public List<String> wordSubsets(String[] A, String[] B) {
	int[] BChars = new int[26];
	for(String b : B) {
	    int[] bchars = new int[26];
	    for (char c : b.toCharArray()) {
		bchars[c - 'a'] = bchars[c - 'a'] + 1;
		if (BChars[c - 'a'] < bchars[c - 'a']) {
		    BChars[c - 'a'] = bchars[c - 'a'];
		}
	    }
	}
	List<String> result = new ArrayList<>();
	for (String a : A) {
	    int[] achars = new int[26];
	    for (char c : a.toCharArray()) {
		achars[c - 'a'] = achars[c - 'a'] + 1;
	    }
	    boolean notMatch = false;
	    for (int i = 0; i < 26; i++) {
		if (BChars[i] > achars[i]) {
		    notMatch = true;
		    break;
		}
	    }
		
	    if (!notMatch) {
		result.add(a);
	    }

	}
	return result;
    }
}
