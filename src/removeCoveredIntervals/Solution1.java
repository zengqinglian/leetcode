package removeCoveredIntervals;

import java.util.Arrays;

public class Solution1 {
    //someone's sort solution, 4ms , beat 90%
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]);
        int count = 1;
        int r = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (r < intervals[i][1]) {
                r = intervals[i][1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] intervals = {{1,4},{3,6},{2,8},{4,8},{3,4}};
        s.removeCoveredIntervals(intervals);
    }
}
