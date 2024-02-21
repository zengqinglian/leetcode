package slidingWindowMaximum;

import java.util.LinkedList;
/*
Runtime
32
ms
Beats
58.62%
of users with Java
Memory
58.52
MB
Beats
66.25%
of users with Java
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k +1];
        for(int i=0; i<k; i++) {
            if (deque.isEmpty()) {
                deque.add(i);
            }else{
                while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]) {
                    deque.pollLast();
                }
                deque.add(i);
            }
        }
        int index = 0;
        res[index++] = nums[deque.peekFirst()];
        for (int i=k; i<nums.length; i++) {
            if (i-deque.peekFirst()+1 >k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
            res[index++] = nums[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        s.maxSlidingWindow(nums, 3);
    }
}
