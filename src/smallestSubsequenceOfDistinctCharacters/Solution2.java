package smallestSubsequenceOfDistinctCharacters;

public class Solution2 {
    // someone's 2 ms solution, beat 90%
    public String smallestSubsequence(String text) {
	int[] count = new int[26];
	for (int i = 0; i < text.length(); i++) {
	    char c = text.charAt(i);
	    count[c - 'a']++;
	}

	boolean[] used = new boolean[26];
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < text.length(); i++) {
	    char c = text.charAt(i);
	    if (used[c - 'a']) {
		count[c - 'a']--;
		continue;
	    }
	    int last = sb.length() - 1;
	    while (sb.length() > 0 && c < sb.charAt(last) && count[sb.charAt(last) - 'a'] > 0) {
		used[sb.charAt(last) - 'a'] = false;
		sb.deleteCharAt(last);
		last -= 1;
	    }
	    used[c - 'a'] = true;
	    sb.append(c);
	    count[c - 'a']--;
	}

	return sb.toString();
	
    }

    public static void main(String[] args) {
	Solution2 s = new Solution2();
	s.smallestSubsequence("leetcode");
    }

}
