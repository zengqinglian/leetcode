package stringWithoutAAAOrBBB;

import java.util.LinkedList;

public class Solution {
    // 2ms solution meet avg speed.
    public String strWithout3a3b(int A, int B) {
	LinkedList<Character> ll = new LinkedList<>();
	char firstChar = A >= B ? 'a' : 'b';
	char secChar = firstChar == 'a' ? 'b' : 'a';
	for (int i = 0; i < Math.min(A, B) * 2; i++) {
	    if(i%2==0) {
		ll.add(firstChar);
	    } else {
		ll.add(secChar);
	    }
	}

	LinkedList<Character> ll2 = new LinkedList<>();
	for (int i = 0; i < Math.abs(A - B); i++) {
	    ll2.add(firstChar);
	    if (!ll.isEmpty())
		ll2.add(ll.removeFirst());
	    if (!ll.isEmpty())
		ll2.add(ll.removeFirst());
	}

	while (!ll.isEmpty()) {
	    ll2.add(ll.removeFirst());
	}

	StringBuilder sb = new StringBuilder();
	while (!ll2.isEmpty()) {
	    sb.append(ll2.removeFirst());
	}
	return sb.toString();
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.strWithout3a3b(4, 1);
    }
}
