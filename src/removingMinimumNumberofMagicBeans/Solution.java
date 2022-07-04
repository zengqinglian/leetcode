package removingMinimumNumberofMagicBeans;

import java.util.Arrays;
import java.lang.Math;
/*
Runtime: 41 ms, faster than 92.13% of Java online submissions for Removing Minimum Number of Magic Beans.
Memory Usage: 62.2 MB, less than 85.28% of Java online submissions for Removing Minimum Number of Magic Beans.
 */
public class Solution {
    public long minimumRemoval(int[] beans) {
        if (beans.length == 1) {
            return 0;
        }
        long total = 0L;
        for (int b : beans) {
            total+=b;
        }
        Arrays.sort(beans);
        long res = Long.MAX_VALUE;
        long sum =0L;
        for (int i=0; i<beans.length; i++) {
            int v = beans[i];
            long diff = total - (long)v * (long)(beans.length - i);
            res = Math.min(res, diff);
        }
        return res;
    }
}
