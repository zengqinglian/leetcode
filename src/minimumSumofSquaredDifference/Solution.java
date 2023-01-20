package minimumSumofSquaredDifference;

import java.util.*;
/*
33ms solution, beat 59%
 */
public class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i=0; i<nums1.length; i++) {
            Node node = map.get(Math.abs(nums1[i]-nums2[i]));
            if (node == null) {
                node = new Node(Math.abs(nums1[i]-nums2[i]), 1);
                map.put(Math.abs(nums1[i]-nums2[i]), node);
            }else{
                node.cnt=node.cnt+1;
            }
        }
        List<Node> list = new ArrayList<>(map.values());
        Collections.sort(list, (a,b)-> (int)(b.diff-a.diff));
        long remain = k1+k2;
        long total = 0;
        for(int i=0; i<list.size(); i++) {
            Node current = list.get(i);
            if (remain==0) {
                total += ((long)current.diff * (long)current.diff * (long)current.cnt);
            }else {
                if (i + 1 < list.size()) {
                    Node next = list.get(i + 1);
                    if ((long) (current.diff - next.diff) * current.cnt > remain) {
                        long v = remain / current.cnt;
                        long r = remain % current.cnt;
                        total += ((current.diff - v - 1) * (current.diff - v - 1) * r);
                        total+=((current.diff - v ) * (current.diff - v ) * (current.cnt - r));
                        remain = 0;
                    } else {
                        next.cnt = next.cnt + current.cnt;
                        remain = remain - ((current.diff - next.diff) * current.cnt);
                    }
                } else {
                    if ((long) current.diff * (long) current.cnt <= remain) {
                        return 0;
                    } else {
                        long left = ((long) current.diff * (long) current.cnt - remain);
                        long v = remain / current.cnt;
                        long r = remain % current.cnt;
                        total += ((current.diff - v - 1) * (current.diff - v - 1) * r);
                        total += ((current.diff - v ) * (current.diff - v ) * (current.cnt- r));
                        return total;
                    }
                }
            }
        }
        return total;
    }

    private static class Node {
        private long diff;
        private long cnt;
        Node(long diff, long cnt) {
            this.diff = diff;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1,4,10,12};
        int[] nums2 = {5,8,6,9};
        s.minSumSquareDiff(nums1, nums2, 1,1);
    }
}
