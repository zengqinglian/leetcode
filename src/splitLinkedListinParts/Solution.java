package splitLinkedListinParts;

public class Solution {
  // 5ms solution meat avg speed.
  public ListNode[] splitListToParts(ListNode root, int k) {
    int length = 0;

    ListNode node = root;
    while (node != null) {
      length++;
      node = node.next;
    }

    int avg = length / k;
    int remain = length % k;

    int index = 0;
    ListNode[] nodes = new ListNode[k];
    ListNode head = root;
    while (index < k) {
      if (head == null) {
        nodes[index] = null;
      } else {
        nodes[index] = head;
        ListNode previous = null;
        for (int i = 0; i < avg; i++) {
          if (head == null) {
            break;
          } else {
            previous = head;
            head = head.next;
          }
        }
        if (remain > 0) {
          previous = head;
          head = head.next;
          remain--;
        }
        if (head != null) {
          previous.next = null;
        }
      }

      index++;
    }
    return nodes;

  }



  private static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
