package orderlyQueue;

import java.util.Arrays;

public class Solution {
    // 6ms solution, meet avg speed
    public String orderlyQueue(String S, int K) {
	char[] chars = S.toCharArray();
	if (K == 1) {
	    String min = S;
	    String cur = S;
	    for (int i = 0; i < S.length(); i++) {
		String newString = cur.substring(1) + cur.charAt(0);
		if (newString.compareTo(min) < 0) {
		    min = newString;
		}
		cur = newString;
	    }
	    return min;
	} else {
	    Arrays.sort(chars);
	    return String.valueOf(chars);
	}

    }



    public static void main(String[] args) {
	Solution s = new Solution();
	s.orderlyQueue("nhtq", 1);
    }
}
