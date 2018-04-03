package reverseLinkedListII;

import java.util.LinkedList;

public class Solution {
  // 4ms solution - beat and match 90%
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == n) {
      return head;
    }
    LinkedList<ListNode> deque = new LinkedList<>();

    ListNode cur = head;
    ListNode sNode = null;
    ListNode eNode = null;
    for (int i = 1; i <= n; i++) {
      if (i == m - 1) {
        sNode = cur;
      }
      if (i == n) {
        eNode = cur.next;
      }
      if (i >= m && i <= n) {
        deque.add(cur);
      }
      cur = cur.next;
    }

    ListNode newHead = head;
    while (deque.size() > 1) {
      ListNode s = deque.pollFirst();
      ListNode e = deque.peekLast();

      e.next = s.next;

      if (sNode != null) {
        sNode.next = e;
      } else {
        newHead = e;
      }
      sNode = e;
      s.next = eNode;
      eNode = s;
    }

    if (deque.isEmpty()) {
      return newHead;
    }

    ListNode node = deque.getFirst();
    sNode.next = node;
    node.next = eNode;

    return newHead;

  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    public String toString() {
      return "val=" + val;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    s.reverseBetween(node1, 2, 4);
  }
}

