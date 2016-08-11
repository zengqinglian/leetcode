package linkedListRandomNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {

    /**
     * @param head
     *            The linked list's head. Note that the head is guanranteed to
     *            be not null, so it contains at least one node.
     */
    private Map<Integer, ListNode> map = new HashMap<>();
    public Solution(ListNode head) {
        int index = 0;
        ListNode loop = head;
        while (loop != null) {
            map.put(index, loop);
            index++;
            loop = loop.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int size = map.size();
        Random random = new Random();
        int key = random.nextInt(size);
        return map.get(key).val;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(110);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(40);
        ListNode node5 = new ListNode(50);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Solution s = new Solution(node1);
        System.out.println(s.getRandom());
    }

}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(head); int param_1 = obj.getRandom();
 */