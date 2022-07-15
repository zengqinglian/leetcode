package maximumTotalImportanceofRoads;

import java.util.Arrays;
/*
Runtime: 13 ms, faster than 65.08% of Java online submissions for Maximum Total Importance of Roads.
Memory Usage: 118.3 MB, less than 74.35% of Java online submissions for Maximum Total Importance of Roads.
 */
public class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] array = new int[n];
        for (int[] road : roads) {
            array[road[0]]++;
            array[road[1]]++;
        }
        Arrays.sort(array);
        long total = 0;
        for (int i=n; i>=1; i--) {
            total += (1L * array[i-1] * i ) ;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] roads = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        s.maximumImportance(5, roads);
    }
}
