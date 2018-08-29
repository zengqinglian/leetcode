package linkedListComponents;

public class Solution {
    // 7ms solution, beat 90%
    public int numComponents(ListNode head, int[] G) {
	boolean[] mark = new boolean[10000];
	for (int i : G) {
	    mark[i] = true;
	}

	boolean cur = false;
	int result = 0;
	while (head != null) {
	    if (!cur) {
		if (mark[head.val]) {
		    result++;
		    cur = true;
		}
	    } else {
		if (!mark[head.val]) {
		    cur = false;
		}
	    }
	    head = head.next;
	}
	return result;
    }

    public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	}
    }
}
