package minimumNumberofArrowstoBurstBalloons;

import java.util.Arrays;
/*
Runtime
54 ms
Beats
57.14%
Memory
76.5 MB
Beats
65.81%
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length <=1) {
            return points.length;
        }
        Arrays.sort(points, (a,b) ->{
            if (a[0] != b[0]) {
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });

        int i = 0;
        int count = 0;
        while(i<points.length) {
            int left = points[i][0];
            int right = points[i][1];
            int j = i+1;
            while (j<points.length && overlapped(left , right, points[j])) {
                left = Math.max(left, points[j][0]);
                right = Math.min(right, points[j][1]);
                j++;
            }
            i = j;
            count++;
        }
        return count;
    }

    private boolean overlapped(int left, int right, int[] point) {
        if (left <= point[0] && right>=point[0]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        s.findMinArrowShots(points);
    }
}
