package longestRepeatingCharacterReplacement;

public class Solution1 {
    // 8ms solution , meet avg speed.
    public int characterReplacement(String s, int k) {
	boolean[] marker = new boolean[26];
	int max = 0;
	for (char c : s.toCharArray()) {
	    if (marker[c - 'A']) {
		continue;
	    } else {
		max = Math.max(max, getMaxLen(s, k, c));
		marker[c - 'A'] = true;
	    }
	}
	return max;
    }

    private int getMaxLen(String s, int k, char c) {
	int start = 0, end = start;
	int len = 0;
	int max = 0;
	while (end < s.length() && start + k < s.length()) {
	    char chr = s.charAt(end);
	    if (chr == c) {
		len++;
		end++;
	    } else {
		if (k > 0) {
		    k--;
		    len++;
		    end++;
		}else {
		    if(k==0) {
			max = Math.max(max, len);
		    }
		    char startChr = s.charAt(start);
		    if(startChr ==c) {
			len--;
			start++;
		    } else {
			len--;
			start++;
			k++;
		    }
		}
	    }
	}
	return Math.max(max, len);
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.characterReplacement("ABAB", 2);
    }
}
