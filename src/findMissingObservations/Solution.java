package findMissingObservations;
/*
Runtime: 3 ms, faster than 98.97% of Java online submissions for Find Missing Observations.
Memory Usage: 60.3 MB, less than 92.27% of Java online submissions for Find Missing Observations.
 */
public class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int total = (rolls.length + n ) * mean;
        int totalM = 0;
        for( int r :  rolls) {
            totalM += r;
        }
        if (total - totalM > n * 6 || total - totalM < n) {
            return new int[0];
        }

        int[] res = new int[n];
        int avg = (total-totalM)/n;
        int mod = (total-totalM) % n;
        for(int i=0; i<n; i++) {
            res[i] = avg;
        }
        if (mod > 0) {
            int currentDiff = total - totalM - (avg * n);
            for (int i=0; i<currentDiff; i++) {
                res[i]++;
            }
        }

        return res;
    }
}
