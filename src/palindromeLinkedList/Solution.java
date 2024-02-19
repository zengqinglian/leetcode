package palindromeLinkedList;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        int total = 0;
        while (current !=null) {
            total++;
            current = current.next;
        }
        if (total == 0) {
            return true;
        }
        int mid = total / 2;
        int revertIndex = mid + total %2;
        int counter = 0;
        current = head;
        ListNode tail = null;
        while (current !=null) {
            tail = current;
            if (counter >= revertIndex) {
                ListNode temp = current.next;
                current.next = pre;
                pre = current;
                current = temp;
            }else{
                current = current.next;
            }
            counter++;
        }
        while (tail!=null) {
            if (tail.val != head.val) {
                return false;
            }
            tail = tail.next;
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        s.isPalindrome(head);
    }
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
