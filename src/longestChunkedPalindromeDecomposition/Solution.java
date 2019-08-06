package longestChunkedPalindromeDecomposition;

public class Solution {
    // 2ms solution , beat 50%
    public int longestDecomposition(String text) {
	int i = 0;
	int j = text.length() - 1;
	StringBuilder sb_head = new StringBuilder();
	StringBuilder sb_tail = new StringBuilder();
	int cnt = 0;
	boolean found = false;
	while (i < j) {
	    sb_head.append(text.charAt(i));
	    sb_tail.insert(0, text.charAt(j));
	    if (sb_head.toString().equals(sb_tail.toString())) {
		cnt += 2;
		sb_head.setLength(0);
		sb_tail.setLength(0);
		found = true;
	    } else {
		found = false;
	    }
	    i++;
	    j--;
	}

	if (!found) {
	    cnt += 1;
	} else {
	    if (i == j) {
		cnt += 1;
	    }

	}

	return cnt;
    }
}
