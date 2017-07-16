package mergekSortedLists;

import java.util.PriorityQueue;

public class Solution1 {
  // priority queue solution - beat 30%
  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (ListNode node : lists) {
      ListNode currentNode = node;
      while (currentNode != null) {
        queue.add(currentNode.val);
        currentNode = currentNode.next;
      }
    }

    if (queue.isEmpty()) {
      return null;
    } else {
      ListNode head = new ListNode(queue.poll());
      ListNode current = head;
      while (!queue.isEmpty()) {
        ListNode newNode = new ListNode(queue.poll());
        current.next = newNode;
        current = newNode;
      }
      return head;
    }
  }

  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
