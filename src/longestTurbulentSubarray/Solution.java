package longestTurbulentSubarray;

import java.util.LinkedList;

public class Solution {
    // 21ms solution , beat 5%
    public int maxTurbulenceSize(int[] A) {
	int max = 1;
	LinkedList<Node> ll = new LinkedList<>();
	for (int i = 0; i < A.length; i++) {
	    if (ll.isEmpty()) {
		ll.add(new Node(A[i]));
	    } else if (ll.size() == 1) {
		if (ll.getLast().val == A[i]) {
		    continue;
		} else {
		    Node newNode = new Node(A[i]);
		    if (ll.getLast().val < A[i]) {
			newNode.isUp = true;
		    }
		    ll.add(newNode);
		    max = Math.max(max, 2);
		}
	    } else {
		if (ll.getLast().val == A[i]) {
		    while (ll.size() > 1) {
			ll.removeFirst();
		    }
		} else {
		    if (ll.getLast().val < A[i]) {
			if (!ll.getLast().isUp) {
			    Node newNode = new Node(A[i]);
			    ll.add(newNode);
			    newNode.isUp = true;
			    max = Math.max(max, ll.size());
			} else {
			    while (ll.size() > 1) {
				ll.removeFirst();
			    }
			    Node newNode = new Node(A[i]);
			    ll.add(newNode);
			    newNode.isUp = true;
			}
		    } else {
			if (ll.getLast().isUp) {
			    Node newNode = new Node(A[i]);
			    ll.add(newNode);
			    max = Math.max(max, ll.size());
			} else {
			    while (ll.size() > 1) {
				ll.removeFirst();
			    }
			    Node newNode = new Node(A[i]);
			    ll.add(newNode);
			}
		    }
		}
	    }
	}

	return max;
    }

    private static class Node {
	private int val;
	private boolean isUp = false;

	Node(int val) {
	    this.val = val;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 4, 8, 12, 16 };
	s.maxTurbulenceSize(A);
    }
}
