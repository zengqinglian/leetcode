package removeDuplicatesFromSortedListII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 7ms solution beat only 5%
    public ListNode deleteDuplicates(ListNode head) {
	Map<Integer, Integer> map = new HashMap<>();
	ListNode cur = head;
	while(cur!=null) {
	    if (!map.containsKey(cur.val)) {
		map.put(cur.val, 1);
	    } else {
		map.put(cur.val, 2);
	    }
	    cur = cur.next;
	}
	ListNode newHead = null;
	ListNode newCur = newHead;
	
	cur = head;
	while (cur != null) {
	    if (map.get(cur.val) == 1) {
		ListNode n = new ListNode(cur.val);
		if (newHead == null) {
		    newHead = n;
		    newCur = newHead;
		} else {
		    newCur.next = n;
		    newCur = n;
		}
	    }
	}

	return newHead;
    }

    public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	}
    }
}

