package insertInterval;

/*
Runtime
1 ms
Beats
98.43%
Memory
44 MB
Beats
86.93%
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int indexLeft= -1;
        int indexRight = -1;

        int insertLeft = -1;
        int insertRight = intervals.length;
        for (int i=0; i< intervals.length; i++) {
            if (intervals[i][0] <= newInterval[0] && intervals[i][1]>=newInterval[0]) {
                indexLeft = i;
            }
            if (intervals[i][0] <= newInterval[1] && intervals[i][1]>=newInterval[1]) {
                indexRight = i;
            }
            if (intervals[i][1] < newInterval[0]) {
                insertLeft = i;
            }
            if (intervals[i][0] > newInterval[1] && insertRight == intervals.length) {
                insertRight = i;
            }
        }

        //No overlap
        if (indexLeft==-1 && indexRight==-1) {
            int[][] res = new int[intervals.length - (insertRight - insertLeft -2)][2];
            if(insertLeft >= 0) {
                System.arraycopy(intervals, 0, res, 0,
                        insertLeft+1);
            }
            res[insertLeft+1][0] = newInterval[0];
            res[insertLeft+1][1] = newInterval[1];

            if (insertRight != -1 ) {
                System.arraycopy(intervals, insertRight, res, insertLeft+2,
                        intervals.length - insertRight);
            }
            return res;
        }

        if (indexLeft >= 0 && indexRight == -1) {
            int newLength = intervals.length - (insertRight - indexLeft) +1 ;
            int[][] res = new int[newLength][2];
            System.arraycopy(intervals, 0, res, 0,
                    indexLeft+1);
            res[indexLeft][1] = newInterval[1];

            if (insertRight < intervals.length) {
                System.arraycopy(intervals, insertRight, res, indexLeft+1,
                        intervals.length  - insertRight  );
            }
            return res;
        }

        if (indexLeft==-1 && indexRight >=0) {
            int newLength = intervals.length - (indexRight - insertLeft) + 1;
            int[][] res = new int[newLength][2];
            if (insertLeft >= 0) {
                System.arraycopy(intervals, 0, res, 0,
                        insertLeft+1);
            }
            res[insertLeft+1][0] = newInterval[0];
            res[insertLeft+1][1] = intervals[indexRight][1];
            System.arraycopy(intervals, indexRight+1, res, insertLeft+2,
                    intervals.length-indexRight-1);

            return res;

        }

        if (indexLeft>=0 && indexRight >=0) {
            int mergeLength = indexRight - indexLeft +1;
            int newLength = intervals.length - mergeLength +1;
            int[][] res = new int[newLength][2];

            System.arraycopy(intervals, 0, res, 0,
                    indexLeft+1);

            res[indexLeft][1] = intervals[indexRight][1];

            if (indexRight < intervals.length -1) {
                System.arraycopy(intervals, indexRight+1, res, indexLeft+1,
                        intervals.length  - indexRight -1);
            }
            return res;
        }


        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {{1,5}};
        int[] newIntervals={6,8};
        s.insert(intervals, newIntervals);
    }
}
