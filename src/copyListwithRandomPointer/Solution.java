package copyListwithRandomPointer;


import java.util.HashMap;
import java.util.Map;
/*
Runtime
1 ms
Beats
7.72%
Memory
43.2 MB
Beats
56.76%
 */
public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Integer> oldNodeIndexMap = new HashMap<>();
        Map<Integer, Node> newIndexNodeMap = new HashMap<>();
        Node current = head;
        int index = 0;
        while (current !=null) {
            oldNodeIndexMap.put(current, index);
            Node newNode = new Node(current.val);
            newIndexNodeMap.put(index, newNode);
            current = current.next;
            index++;
        }
        current = head;
        index = 0;
        while (current !=null) {
            Node newNode = newIndexNodeMap.get(index);
            newNode.next = newIndexNodeMap.get(index+1);
            if (current.random==null){
                newNode.random = null;
            }else{
                int oldRandomNodeIndex = oldNodeIndexMap.get(current.random);
                newNode.random = newIndexNodeMap.get(oldRandomNodeIndex);
            }
            current = current.next;
            index++;
        }
        return newIndexNodeMap.get(0);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);

        node7.next = node13;
        node13.next=node11;
        node11.next= node10;
        node10.next = node1;

        node7.random = null;
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;
        s.copyRandomList(node7);

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
