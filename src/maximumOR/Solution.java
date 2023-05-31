package maximumOR;

import java.util.*;
/*

Time Limit over

 */
public class Solution {
    public long maximumOr(int[] nums, int k) {
        int length =0;
        for (int i=0; i<nums.length; i++) {
            length = Math.max(length, Integer.toBinaryString(nums[i]).length());
        }
        long res = 0;
        LinkedList<Node> list = new LinkedList<>();
        for (int i=0; i<nums.length; i++) {
            if (length == Integer.toBinaryString(nums[i]).length()) {
                if (list.isEmpty()) {
                    list.add(new Node(nums[i], false));
                    list.add(new Node(((long)nums[i])<<k, true));
                }else{
                    int loop = list.size();
                    for(int j=0; j<loop; j++) {
                        Node v = list.poll();
                        if (v.moved) {
                            list.add(new Node(v.value | nums[i], true));
                        }else{
                            list.add(new Node((v.value | nums[i]),false));
                            list.add(new Node(v.value | (((long)nums[i])<<k), true));
                        }
                    }
                }

            }else{
                if (list.isEmpty()) {
                    list.add(new Node(nums[i],false));
                }else {
                    int loop = list.size();
                    for (int j = 0; j < loop; j++) {
                        Node v = list.poll();
                        list.add(new Node(v.value | nums[i],v.moved));
                    }
                }
            }

        }
        for (Node v : list) {
            res = Math.max(res, v.value);
        }
        return res;
    }

    private static class Node {
        private long value;
        private boolean moved;

        Node(long value, boolean moved) {
            this.value = value;
            this.moved = moved;
        }
    }

    public static void main(String[] args) {
        int[] array = {94,91,65};
        Solution s= new Solution();
        s.maximumOr(array, 10);
    }
}
