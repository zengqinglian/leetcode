package slidingWindowMedian;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    // solution O(N * logK)
    public double[] medianSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        double[] result;

        result = new double[length - k + 1];

        if (k == 1) {
            for (int i = 0; i < length; i++) {
                result[i] = nums[i];

            }
            return result;
        }

        if (k == 2) {
            for (int i = 0; i < length - 1; i++) {
                result[i] = Double.valueOf((long) nums[i] + (long) nums[i + 1]) / 2;

            }
            return result;
        }

        boolean oddK = (k % 2 == 1);
        // the first element of two queue are the middle elements
        PriorityQueue<Integer> firstHalf = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> secondHalf = new PriorityQueue<>(k);
        for (int i = 0; i < length; i++) {
            // add new element into one of the heap
            if (firstHalf.isEmpty() || nums[i] < firstHalf.peek()) {
                firstHalf.offer(nums[i]);
            } else {
                secondHalf.offer(nums[i]);
            }
            // remove element outside of window
            if (i >= k) {
                if (nums[i - k] <= firstHalf.peek()) {
                    firstHalf.remove(nums[i - k]);
                } else {
                    secondHalf.remove(nums[i - k]);
                }
            }
            // balance two heaps, make sure maxHeap contains one more element if
            // k is odd.
            while (secondHalf.size() >= firstHalf.size() + 1) {
                firstHalf.offer(secondHalf.poll());
            }
            while (firstHalf.size() > secondHalf.size() + 1) {
                secondHalf.offer(firstHalf.poll());
            }
            // add result
            if (i >= k - 1) {
                if (oddK) {
                    result[i - k + 1] = firstHalf.peek();
                } else {
                    result[i - k + 1] = Double.valueOf((long) firstHalf.peek() + (long) secondHalf.peek()) / 2;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 4, 2, 3 };
        s.medianSlidingWindow(nums, 4);
    }

}
