package lastMomentBeforeAllAntsFallOutofaPlank;
/*
Runtime: 1 ms, faster than 23.08% of Java online submissions for Last Moment Before All Ants Fall Out of a Plank.
Memory Usage: 51.4 MB, less than 11.54% of Java online submissions for Last Moment Before All Ants Fall Out of a Plank.
 */
public class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int res = 0;
        for(int i=0; i<left.length; i++){
            res = Math.max(res, left[i]);
        }
        for(int i=0; i<right.length; i++){
            res = Math.max(res, n-right[i]);
        }
        return res;
    }
}
