package maximizeDistancetoClosestPerson;
/*
Runtime
2 ms
Beats
97.75%
Memory
44.4 MB
Beats
75.75%
 */
public class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxGap = 0;
        int previousOneIndex=-1;
        int headGap = 0;
        int tailGap = 0;

        for(int i=0; i<seats.length; i++) {
            if(seats[i]==1) {
                if (previousOneIndex == -1) {
                    previousOneIndex = i;
                    headGap = previousOneIndex;
                }else {
                    int gap = i - previousOneIndex -1;
                    if (gap > maxGap ) {
                        maxGap = gap;
                    }
                    previousOneIndex = i;
                }
            }
        }
        tailGap = seats.length -1 - previousOneIndex;
        int res= maxGap / 2 + maxGap % 2;
        res = Math.max(res, headGap);
        res = Math.max(res, tailGap);

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] seats = {1,0,0,0};
        s.maxDistToClosest(seats);
    }
}
