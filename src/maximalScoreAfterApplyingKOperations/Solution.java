package maximalScoreAfterApplyingKOperations;

import java.util.Comparator;
import java.util.PriorityQueue;
/*
Runtime
211 ms
Beats
40.43%
Memory
60.3 MB
Beats
25%
 */
public class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> q= new PriorityQueue<>(Comparator.reverseOrder());

        for (int n :  nums) {
            q.add(n);
        }

        long res = 0;
        for (int i=0; i<k; i++){
            int val = q.poll();
            if (val == 0) {
                return res;
            }
            res = res + (long)val;
            q.add(ceilDiv(val,3));
        }
        return res;
    }

    private int ceilDiv(int x, int y) {
        final int q = x / y;
        // if the signs are the same and modulo not zero, round up
        if (q * y != x) {
            return q + 1;
        }
        return q;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,10,3,3,3};
        s.maxKelements(nums, 3);
    }
}
