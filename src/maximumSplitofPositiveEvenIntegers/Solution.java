package maximumSplitofPositiveEvenIntegers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
Runtime: 31 ms, faster than 26.52% of Java online submissions for Maximum Split of Positive Even Integers.
Memory Usage: 119 MB, less than 57.12% of Java online submissions for Maximum Split of Positive Even Integers.

 */
public class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 == 1) {
            return Collections.emptyList();
        }

        List<Long> res = new ArrayList<>();
        long total = 0;
        for( long i=2; total<finalSum; i+=2) {
            total += i;
            res.add(i);
        }
        res.remove(total - finalSum);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maximumEvenSplit(2);
    }
}
