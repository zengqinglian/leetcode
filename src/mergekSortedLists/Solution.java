package mergekSortedLists;

public class Solution {
  // time limit over solution
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode head = null;
    ListNode current = head;

    while (true) {
      ListNode minNode = null;
      int index = -1;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          if (minNode == null) {
            minNode = lists[i];
            index = i;
          } else if (minNode.val > lists[i].val) {
            minNode = lists[i];
            index = i;
          }
        }
      }

      if (minNode == null) {
        return head;
      } else {
        if (head == null) {
          lists[index] = minNode.next;
          head = minNode;
          current = minNode;
          head.next = null;
        } else {
          lists[index] = minNode.next;
          current.next = minNode;
          current = minNode;
          minNode.next = null;
        }
      }
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
