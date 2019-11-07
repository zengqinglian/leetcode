package removeZeroSumConsecutiveNodesFromLinkedList;

public class Solution {
    //3ms solution , beat avg 50%
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode cur = head;
        int[] sums = new int[1000];
        ListNode[] nodes = new ListNode[1000];
        int index = 0;
        while(cur != null){
            nodes[index] = cur;

            for(int i= 0; i<=index; i++) {

                sums[i] += cur.val;
                if(sums[i]==0){
                    for(int j=i+1; j<=index; j++){
                        nodes[j]=null;
                        sums[j] =0;
                    }
                    index=i-1;
                    nodes[i]=null;
                }
            }
            cur = cur.next;
            index++;
        }
        ListNode res = null;
        if(nodes[0] == null){
            return null;
        }

        nodes[0].next = null;

        for(int i=1; i<index; i++){
            nodes[i-1].next = nodes[i];
            nodes[i].next = null;
        }


        return nodes[0];

    }

    private static class  ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(-3);
        ListNode n5 = new ListNode(-2);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(-5);
        ListNode n9 = new ListNode(1);

        n1.next =n2;
        n2.next =n3;
        n3.next=n4;
        n4.next =n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        n8.next=n9;
        s.removeZeroSumSublists(n1);
    }
}
