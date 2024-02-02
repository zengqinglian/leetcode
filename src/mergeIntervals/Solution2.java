package mergeIntervals;

import java.util.Arrays;

public class Solution2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int index = 0;
        int[] current = intervals[0];
        for (int i=1; i<intervals.length; i++) {
            if (current[1]>=intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            }else{
                intervals[index] = current;
                current = intervals[i];
                index++;
            }
        }
        intervals[index] = current;
        return Arrays.copyOfRange(intervals, 0, index+1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        s.merge(intervals);
    }

}
