package decodeString;

import java.util.LinkedList;

public class Solution {
    // 1ms solution , beat 80%
    public String decodeString(String s) {
	LinkedList<String> deque = new LinkedList<>();
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (c == '[' ) {
		deque.offer("[");
	    } else if (c == ']') {
		// pop
		StringBuilder tmpSb = new StringBuilder();
		while (!deque.peekLast().equals("[")) {
		    String str = deque.pollLast();
		    tmpSb.append(str);
		}
		String base = tmpSb.toString();
		tmpSb.setLength(0);
		deque.pollLast();
		int pow=0;
		int repeat=0;
		while (!deque.isEmpty() && deque.peekLast().charAt(0) >= '0' && deque.peekLast().charAt(0) <= '9') {
		    repeat += (int) Math.pow(10, pow) * Integer.valueOf(deque.pollLast());
		    pow++;
		}
		for (int j = 1; j <= repeat; j++) {
		    tmpSb.append(base);
		}
		deque.offer(tmpSb.toString());

	    } else if (c >= '0' && c <= '9') {
		deque.offer(String.valueOf(c));
	    } else {
		deque.offer(String.valueOf(c));
	    }
	}
	StringBuilder sb = new StringBuilder();
	while (!deque.isEmpty()) {
	    sb.append(deque.pollLast());
	}
	
	return sb.reverse().toString();
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.decodeString("2[20[bc]31[xy]]xd4[rt]");
    }

}
