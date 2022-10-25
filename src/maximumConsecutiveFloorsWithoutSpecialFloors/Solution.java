package maximumConsecutiveFloorsWithoutSpecialFloors;

import java.util.Arrays;
/*
Runtime: 47 ms, faster than 53.08% of Java online submissions for Maximum Consecutive Floors Without Special Floors.
Memory Usage: 78.1 MB, less than 17.69% of Java online submissions for Maximum Consecutive Floors Without Special Floors.

 */
public class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int res = 0;
        res = Math.max(res, special[0]-bottom);
        res = Math.max(res, top - special[special.length-1]);
        for (int i=1; i<special.length; i++) {
            res = Math.max(res, special[i]-special[i-1]-1);
        }
        return res;
    }
}
