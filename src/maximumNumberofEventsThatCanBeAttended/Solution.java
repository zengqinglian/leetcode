package maximumNumberofEventsThatCanBeAttended;

import java.util.Arrays;

public class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        boolean[] seen = new boolean[100001];
        int count = 0;
        int lastFound = 0;
        for(int i = 0; i < events.length; i++) {
            int end = events[i][1];
            int start = (i > 0 && events[i-1][0] == events[i][0])? lastFound : events[i][0];
            for(int j = start; j <= end; j++){
                if(!seen[j]) {
                    seen[j] = true;
                    lastFound = j;
                    count++;
                    break;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //
        //[[1,2],[2,2],[3,3],[3,4],[3,4]]
        int[][] events = {{1,2},{1,2},{3,3},{3,4},{3,4}};
        s.maxEvents(events);
    }
}
