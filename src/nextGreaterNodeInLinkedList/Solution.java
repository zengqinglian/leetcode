package nextGreaterNodeInLinkedList;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    // 34ms solution , beat 80%
    public int[] nextLargerNodes(ListNode head) {
	int[] result = new int[10000];
	Stack<int[]> stack = new Stack<>();
	int idx = 0;
	ListNode cur = head;
	while (cur != null) {
	    if(stack.isEmpty()) {
		int[] p = {idx, cur.val};
		stack.push(p);
	    } else {
		while (!stack.isEmpty()) {
		    int[] top = stack.peek();
		    if (top[1] < cur.val) {
			stack.pop();
			result[top[0]] = cur.val;
		    } else {
			break;
		    }
		}
		int[] newP = { idx, cur.val };
		stack.push(newP);
	    }
	    cur = cur.next;
	    idx++;
	}

	return Arrays.copyOf(result, idx);
    }

    private static class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	}
    }

}
