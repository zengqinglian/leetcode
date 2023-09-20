package nonoverlappingIntervals;

import java.util.Arrays;
/*
Runtime
61 ms
Beats
25.96%
Memory
96.5 MB
Beats
74.66%
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <=1) {
            return 0;
        }
        Arrays.sort(intervals, (a,b)->{
            if (a[0]!=b[0]) {
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        int remove = 0;
        int j = 0;
        for (int i=1; i<intervals.length; i++) {
            int[] start = intervals[j];
            int[] end = intervals[i];
            if (start[1] >= end[1]) {
                j=i;
                remove++;
            }else if (end[1]>start[1] && end[0] < start[1]){
                remove++;
            }else{
                j=i;
            }
        }
        return remove;
    }


}
